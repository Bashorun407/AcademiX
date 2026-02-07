package com.lytwind.academix.repository.projection;

public interface TeacherView {
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhoneNumber();
    String getEmployeeId();
    DepartmentInfo getDepartment();

    interface DepartmentInfo{
        String getName();
    }
}
