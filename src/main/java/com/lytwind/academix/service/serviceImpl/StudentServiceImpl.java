package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.GuardianRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void updateStudentGuardian(Long studentId, Long guardianId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new RuntimeException("Guardian not found"));
        student.setGuardian(guardian);
        studentRepository.save(student);
    }
}
