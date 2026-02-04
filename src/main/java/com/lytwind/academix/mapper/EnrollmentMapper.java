package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.EnrollmentResponseDto;
import com.lytwind.academix.entity.Enrollment;
import com.lytwind.academix.repository.projection.EnrollmentView;

public class EnrollmentMapper {

    //For Entity
    public static EnrollmentResponseDto mapToEnrollmentDto(Enrollment enrollment){
        return new EnrollmentResponseDto(
                enrollment.getStudent().getFirstName(),
                enrollment.getStudent().getLastName(),
                enrollment.getStudent().getStudentRegNumber(),
                enrollment.getCourse().getCourseCode(),
                enrollment.getCourse().getTitle(),
                enrollment.getEnrollmentDate().toString()
        );
    }

    //For Interface Projection
    public static  EnrollmentResponseDto mapToEnrollmentDto(EnrollmentView enrollmentView){
        return new EnrollmentResponseDto(
                enrollmentView.getStudent().getFirstName(),
                enrollmentView.getStudent().getLastName(),
                enrollmentView.getStudent().getStudentRegNumber(),
                enrollmentView.getCourse().getCourseCode(),
                enrollmentView.getCourse().getTitle(),
                enrollmentView.getEnrollmentDate().toString()
        );
    }
}
