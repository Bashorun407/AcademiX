package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.dto.StudentUpdateRequestDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public StudentResponseDto registerStudent(String firstName, String lastName, String email, String phoneNumber,
                                              String studentRegNumber, LocalDate dateOfBirth, String classroomNumber,
                                              Long guardianId) {
        if (studentRepository.existsByStudentRegNumberAndLastName(studentRegNumber, lastName))
            throw new RuntimeException("Student with the details already exist.");

        Guardian guardian = guardianRepository.getReferenceById(guardianId);

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setStudentRegNumber(studentRegNumber);
        student.setDateOfBirth(dateOfBirth);
        student.setGuardian(guardian);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentResponseDto(savedStudent);
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));

        return StudentMapper.mapToStudentResponseDto(student);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::mapToStudentResponseDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentUpdateRequestDto studentDetails) {
        Student student = studentRepository.getReferenceById(id);

        Classroom classroom = classroomRepository.findByRoomNumber(studentDetails.classroomNumber())
                .orElseThrow();

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
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new RuntimeException("Guardian not found"));
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

}
