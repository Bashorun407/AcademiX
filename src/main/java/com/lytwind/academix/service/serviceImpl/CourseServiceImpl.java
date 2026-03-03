package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.exception.ResourceNotFoundException;
import com.lytwind.academix.mapper.CourseMapper;
import com.lytwind.academix.repository.CourseRepository;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public CourseResponseDto createCourse(String departmentName, String courseCode, String title, int creditUnits) {
        if(courseRepository.existsByCourseCode(courseCode))
            throw new IllegalArgumentException("Course already exists.");

        Department department = departmentRepository.findByNameIgnoreCase(departmentName)
                .orElseThrow(()-> new ResourceNotFoundException("Department with this name: " + departmentName + " does not exist"));
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setTitle(title);
        course.setCreditUnits(creditUnits);
        course.setDepartment(department);

        Course savedCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseResponseDto(savedCourse);

    }

    @Override
    public List<CourseResponseDto> allCourses() {
        return courseRepository.findAll().stream().map(CourseMapper::mapToCourseResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDto updateCourse(String courseCode, String title, int creditUnits, String departmentName) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(()-> new ResourceNotFoundException("Course with this course code: "+ courseCode
                        + " does not exist."));

        Department department = departmentRepository.findByNameIgnoreCase(departmentName)
                        .orElseThrow(()-> new ResourceNotFoundException("There is no department with this name: " + departmentName));
        course.setTitle(title);
        course.setCreditUnits(creditUnits);
        course.setDepartment(department);

        return CourseMapper.mapToCourseResponseDto(courseRepository.save(course));
    }

    @Override
    public String deleteCourse(String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(()-> new ResourceNotFoundException("Course with this course code: "+ courseCode
                        + " does not exist."));

        courseRepository.delete(course);

        return "Course has been successfully deleted.";
    }
}
