package com.lytwind.academix.service;

import com.lytwind.academix.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(String departmentName);
    List<DepartmentDto> allDepartments();
}
