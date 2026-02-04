package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.repository.ClassroomRepository;
import com.lytwind.academix.repository.CourseRepository;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.service.AcademicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademicServiceImpl implements AcademicService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public Course createCourse(Course course, Long deptId) {
        Department dept = departmentRepository.findById(deptId).orElseThrow();
        course.setDepartment(dept);
        return courseRepository.save(course);
    }

    @Override
    public Classroom setupClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }
}
