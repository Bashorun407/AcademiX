package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.*;
import com.lytwind.academix.repository.AttendanceRepository;
import com.lytwind.academix.repository.CourseRepository;
import com.lytwind.academix.repository.EnrollmentRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final AttendanceRepository attendanceRepository;

    @Override
    @Transactional
    public Enrollment enrollStudent(Long studentId, String courseCode) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseCode).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Attendance recordAttendance(Long studentId, LocalDate date, AttendanceStatus status) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(date);
        attendance.setStatus(status);
        return attendanceRepository.save(attendance);
    }
}
