package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.DepartmentDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.repository.projection.DepartmentView;

public class DepartmentMapper {

    //For Entity
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getName()
        );
    }

    //For Interface Projection
    public static DepartmentDto mapToDepartmentDto(DepartmentView departmentView){
        return new DepartmentDto(
                departmentView.getName()
        );
    }
}
