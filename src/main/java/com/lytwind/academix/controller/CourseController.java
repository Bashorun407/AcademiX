package com.lytwind.academix.controller;

import com.lytwind.academix.dto.CourseRequestDto;
import com.lytwind.academix.dto.CourseResponseDto;
import com.lytwind.academix.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto){
        CourseResponseDto course = courseService.createCourse(
                courseRequestDto.departmentName(),
                courseRequestDto.courseCode(),
                courseRequestDto.title(),
                courseRequestDto.creditUnits()

        );

        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> allCourses(){
        List<CourseResponseDto> allCourses = courseService.allCourses();

        return ResponseEntity.status(HttpStatus.OK).body(allCourses);
    }
}
