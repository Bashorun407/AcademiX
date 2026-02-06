package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.dto.EnrollmentResponseDto;
import com.lytwind.academix.entity.*;
import com.lytwind.academix.mapper.AttendanceMapper;
import com.lytwind.academix.mapper.EnrollmentMapper;
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


    @Override
    public Enrollment enrollStudent(Long studentId, String courseCode) {
        return null;
    }

    @Override
    public Attendance recordAttendance(Long studentId, LocalDate date, AttendanceStatus status) {
        return null;
    }
}
