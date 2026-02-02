package com.lytwind.academix.dto;

import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Student;

public record EnrollmentRequestDto(
        Long studentId,
        Long courseId
) {
}
