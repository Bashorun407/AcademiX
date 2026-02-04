package com.lytwind.academix.service;

import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Course;

public interface AcademicService {
    Course createCourse(Course course, Long deptId);
    Classroom setupClassroom(Classroom classroom);
}
