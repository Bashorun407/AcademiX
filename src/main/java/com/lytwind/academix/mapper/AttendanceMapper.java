package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.AttendanceRequestDto;
import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.entity.Attendance;
import com.lytwind.academix.repository.projection.AttendanceView;

public class AttendanceMapper {

    //For Entity
    public static AttendanceResponseDto mapToAttendanceResponseDto(Attendance attendance){
        return new AttendanceResponseDto(
                attendance.getDate(),
                attendance.getStatus(),
                attendance.getStudent().getFirstName(),
                attendance.getStudent().getLastName(),
                attendance.getStudent().getStudentRegNumber()
        );
    }

    //For Interface Projection
    public static AttendanceResponseDto mapToAttendanceResponseDto(AttendanceView attendanceView){
        return new AttendanceResponseDto(
                attendanceView.getDate(),
                attendanceView.getStatus(),
                attendanceView.getStudent().getFirstName(),
                attendanceView.getStudent().getFirstName(),
                attendanceView.getStudent().getStudentRegNumber()
        );
    }
}
