package com.lytwind.academix.repository.projection;

import com.lytwind.academix.entity.AttendanceStatus;

import java.time.LocalDate;

public interface AttendanceView {
    LocalDate getDate();
    AttendanceStatus getStatus();
    StudentInfo getStudent();

    interface StudentInfo{
        String getFirstName();
        String getLastName();
        String getStudentRegNumber();
    }
}
