package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.projection.StudentView;

public class StudentMapper {

    //For Entity
    public static StudentResponseDto mapToStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getClassroom().getRoomNumber(),
                student.getGuardian().getFirstName(),
                student.getGuardian().getLastName()
        );
    }

    //For Interface Projection
    public static StudentResponseDto mapToStudentResponseDto(StudentView studentView){
        return new StudentResponseDto(
                studentView.getFirstName(),
                studentView.getLastName(),
                studentView.getEmail(),
                studentView.getPhoneNumber(),
                studentView.getClassRoom().getRoomNumber(),
                studentView.getGuardian().getFirstName(),
                studentView.getGuardian().getLastName()
        );
    }

}
