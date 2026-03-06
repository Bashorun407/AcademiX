package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.dto.StudentUpdateRequestDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.exception.ResourceNotFoundException;
import com.lytwind.academix.mapper.StudentMapper;
import com.lytwind.academix.repository.ClassroomRepository;
import com.lytwind.academix.repository.GuardianRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public StudentResponseDto registerStudent(String firstName, String lastName, String email,
                                              String phoneNumber, LocalDate dateOfBirth, String classroomNumber,
                                              Long guardianId) {
        if (studentRepository.existsByEmailAndLastName(email, lastName))
            throw new RuntimeException("Student with the details already exist.");

        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(()-> new ResourceNotFoundException("There is no guardian with this id: " + guardianId));

        Classroom classroom = classroomRepository.findByRoomNumber(classroomNumber)
                .orElseThrow(()-> new ResourceNotFoundException("There is no Classroom with this room number " + classroomNumber));

        //checks if the class capacity is still less than maximum capacity
        if(classroom.getCapacity() ==  classroom.getMaxRoomCapacity()){
            throw new RuntimeException("Class is filled up. Check another class.");
        }

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setStudentRegNumber(generateStudentRegNumber());
        student.setDateOfBirth(dateOfBirth);
        student.setGuardian(guardian);
        student.setClassroom(classroom);

        Student savedStudent = studentRepository.save(student);

        //This increases the number of students in a class provided maximum classroom capacity is not reached.

        classroom.setCapacity(classroom.getCapacity() + 1);
        classroomRepository.save(classroom);

        return StudentMapper.mapToStudentResponseDto(savedStudent);
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));

        return StudentMapper.mapToStudentResponseDto(student);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::mapToStudentResponseDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto updateStudent(String studentRegNumber, StudentUpdateRequestDto studentDetails) {
        Student student = studentRepository.findByStudentRegNumber(studentRegNumber)
                .orElseThrow(()-> new ResourceNotFoundException("There is no Student with this Registration Number: "
                + studentRegNumber));

        Classroom classroom = classroomRepository.findByRoomNumber(studentDetails.classroomNumber())
                .orElseThrow(()-> new ResourceNotFoundException("The class with this id: " +
                        studentDetails.classroomNumber() + " does not exist"));

        // Update fields from the MappedSuperclass and Student class
        student.setEmail(studentDetails.email());
        student.setPhoneNumber(studentDetails.phoneNumber());
        student.setClassroom(classroom);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentResponseDto(student);
    }

    @Override
    @Transactional
    public StudentResponseDto updateStudentGuardian(Long studentId, Long guardianId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new ResourceNotFoundException("Guardian not found"));
        student.setGuardian(guardian);

        Student updatedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentResponseDto(updatedStudent);
    }

    @Override
    public String deleteStudent(Long id) {
        Student student = studentRepository.getReferenceById(id);
        studentRepository.delete(student);

        return "Student details removed.";
    }


    //Helper method
    private String generateStudentRegNumber() {
        String timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyMMdd"));
        return "REG-" + timestamp;
    }
}
