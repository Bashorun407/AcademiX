package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.EnrollmentResponseDto;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Enrollment;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.exception.ResourceNotFoundException;
import com.lytwind.academix.mapper.EnrollmentMapper;
import com.lytwind.academix.repository.CourseRepository;
import com.lytwind.academix.repository.EnrollmentRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.repository.projection.EnrollmentView;
import com.lytwind.academix.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public EnrollmentResponseDto enrollStudent(Long studentId, String courseCode) {
         if (enrollmentRepository.existsByStudentIdAndCourseCourseCode(studentId, courseCode))
             throw new IllegalArgumentException("Student has already been enrolled.");

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalArgumentException("There is no student by this ID: " + studentId));
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(()-> new IllegalArgumentException("There is no course with this course code: " + courseCode));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return EnrollmentMapper.mapToEnrollmentDto(savedEnrollment);
    }

    @Override
    public List<EnrollmentResponseDto> getAllEnrolledStudents() {
        return enrollmentRepository.findAll()
                .stream().map(EnrollmentMapper::mapToEnrollmentDto).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentResponseDto> getStudentEnrolledCourses(Long studentId) {

        return enrollmentRepository.findByStudentId(studentId).stream()
                .map(EnrollmentMapper::mapToEnrollmentDto).collect(Collectors.toList());
    }

    @Override
    public String deleteStudentCourseEnrollment(Long studentId, String courseCode) {
        if (!enrollmentRepository.existsByStudentIdAndCourseCourseCode(studentId, courseCode))
            throw new IllegalArgumentException("This student with ID: ." + studentId + " was not registered for " +
                    "course: " + courseCode);

        Enrollment enrollment = enrollmentRepository.findByStudentIdAndCourseCourseCode(studentId, courseCode)
                .orElseThrow(()-> new ResourceNotFoundException("Student with student ID: " + studentId +
                        " and course code: " + courseCode));

        enrollmentRepository.delete(enrollment);

        return "Enrollment has been successfully removed.";
    }
}
