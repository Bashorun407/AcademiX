package com.lytwind.academix.dto;

import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;

public record AttendanceRequestDto(
        Long studentId,
        AttendanceStatus status
) {
    public AttendanceRequestDto{
        if(studentId == null){
            throw new IllegalArgumentException("Student ID cannot be null");
        }

        if(status == null ||
                !((status.toString().toUpperCase().contentEquals("PRESENT")
                || status.toString().toUpperCase().contentEquals("ABSENT")
                || status.toString().toUpperCase().contentEquals("LATE")
                || status.toString().toUpperCase().contentEquals("EXCUSED")))
        ){
            throw new IllegalArgumentException("Attendance Status cannot be null " +
                    "or different from [PRESENT, ABSENT, LATE, EXCUSED");
        }
    }
}
