package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.ClassroomRequestDto;
import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.service.AcademicService;
import org.springframework.stereotype.Service;

@Service
public class AcademicServiceImpl implements AcademicService {


    @Override
    public CourseResponseDto createCourse(Course course, Long deptId) {
        return null;
    }

    @Override
    public ClassroomRequestDto setupClassroom(Classroom classroom) {
        return null;
    }
}
