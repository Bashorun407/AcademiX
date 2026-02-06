package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.ClassroomDto;
import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.dto.DepartmentDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.mapper.ClassroomMapper;
import com.lytwind.academix.mapper.CourseMapper;
import com.lytwind.academix.mapper.DepartmentMapper;
import com.lytwind.academix.repository.ClassroomRepository;
import com.lytwind.academix.repository.CourseRepository;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.service.AcademicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AcademicServiceImpl implements AcademicService {


    @Override
    public CourseResponseDto createCourse(Course course, Long deptId) {
        return null;
    }

    @Override
    public ClassroomDto setupClassroom(Classroom classroom) {
        return null;
    }
}
