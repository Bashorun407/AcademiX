package com.lytwind.academix.service;

import com.lytwind.academix.dto.DepartmentRequestDto;
import com.lytwind.academix.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(String departmentName);
    List<DepartmentResponseDto> allDepartments();
    DepartmentResponseDto updateDepartment(String departmentName, String updateName);
    String removeDepartment(String departmentName);
}
