package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.StudentRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final ClassroomRepository classroomRepository;

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
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentDetails) {
        Student student = studentRepository.getReferenceById(id);

        Classroom classroom = classroomRepository.findByRoomNumber(studentDetails.classroomNumber())
                .orElseThrow();

        // Update fields from the MappedSuperclass and Student class
        student.setFirstName(studentDetails.firstName());
        student.setLastName(studentDetails.lastName());
        student.setEmail(studentDetails.email());
        student.setStudentRegNumber(studentDetails.studentRegNumber());
        student.setDateOfBirth(studentDetails.dateOfBirth());

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
