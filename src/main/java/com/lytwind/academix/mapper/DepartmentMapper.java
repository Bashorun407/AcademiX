package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.DepartmentRequestDto;
import com.lytwind.academix.dto.DepartmentResponseDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.repository.projection.DepartmentView;

public class DepartmentMapper {

    //For Entity
    public static DepartmentResponseDto mapToDepartmentDto(Department department){
        return new DepartmentResponseDto(
                department.getName()
        );
    }

    //For Interface Projection
    public static DepartmentResponseDto mapToDepartmentDto(DepartmentView departmentView){
        return new DepartmentResponseDto(
                departmentView.getName()
        );
    }
}
