package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.TeacherResponseDto;
import com.lytwind.academix.entity.Teacher;
import com.lytwind.academix.repository.projection.TeacherView;

public class TeacherMapper {

    //For Entity
    public static TeacherResponseDto mapToTeacherResponseDto(Teacher teacher){
        return new TeacherResponseDto(
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getPhoneNumber(),
                teacher.getEmployeeId(),
                teacher.getDepartment().getName()
        );
    }

    //For Interface Projection
    public static TeacherResponseDto mapToTeacherResponseDto(TeacherView teacherView){
        return new TeacherResponseDto(
                teacherView.getFirstName(),
                teacherView.getLastName(),
                teacherView.getEmail(),
                teacherView.getPhoneNumber(),
                teacherView.getEmployeeId(),
                teacherView.getDepartment().getName()
        );
    }
}
