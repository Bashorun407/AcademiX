package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Student;

public record EnrollmentRequestDto(
        Long studentId,
        String courseCode
) {
    public EnrollmentRequestDto{
        if(studentId == null){
            throw new IllegalArgumentException("Student ID cannot be null.");
        }

        if(courseCode == null){
            throw new IllegalArgumentException("Course code cannot be null.");
        }
    }
}
