package com.lytwind.academix.service;

import com.lytwind.academix.entity.Attendance;
import com.lytwind.academix.entity.AttendanceStatus;
import com.lytwind.academix.entity.Enrollment;

import java.time.LocalDate;

public interface AdminService {
    Enrollment enrollStudent(Long studentId, String courseCode);
    Attendance recordAttendance(Long studentId, LocalDate date, AttendanceStatus status);
}
