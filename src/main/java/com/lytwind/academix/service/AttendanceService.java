package com.lytwind.academix.service;

import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    AttendanceResponseDto recordAttendance(Long studentId, AttendanceStatus attendanceStatus);

    List<AttendanceResponseDto> studentAttendance(Long studentId);

    List<AttendanceResponseDto> studentAttendanceWithDate(Long studentId, LocalDate date);
}
