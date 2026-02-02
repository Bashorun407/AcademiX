package com.lytwind.academix.repository.projection;

import com.lytwind.academix.entity.Course;
import com.lytwind.academix.entity.Student;

import java.time.LocalDate;

public interface EnrollmentView {
    LocalDate getEnrollmentDate();
    StudentInfo getStudent();
    CourseInfo getCourse();

    interface StudentInfo{
        String getFirstName();
        String getLastName();
        String getStudentRegNumber();
    }

    interface CourseInfo{
        String getCourseCode();
        String getTitle();
    }
}
