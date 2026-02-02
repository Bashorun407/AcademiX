package com.lytwind.academix.repository.projection;

public interface CourseView {
    String getCourseCode();
    String getTitle();
    int getCreditUnits();

    DepartmentInfo getDepartment();

    interface DepartmentInfo{
        String getName();
    }
}
