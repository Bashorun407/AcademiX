package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.repository.projection.CourseView;

public class CourseMapper {
    //For Entity
    public static CourseResponseDto mapToCourseResponseDto(Course course){
        return new CourseResponseDto(
                course.getCourseCode(),
                course.getTitle(),
                course.getCreditUnits(),
                course.getDepartment().getName()
        );
    }

    public static CourseResponseDto mapToCourseResponseDto(CourseView courseView){
        return new CourseResponseDto(
          courseView.getCourseCode(),
          courseView.getTitle(),
          courseView.getCreditUnits(),
          courseView.getDepartment().getName()
        );
    }
}
