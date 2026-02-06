package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.DepartmentDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.mapper.DepartmentMapper;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(String departmentName) {
        if(departmentRepository.existsByNameIgnoreCase(departmentName))
            throw new IllegalArgumentException("Department already exists.");

        Department department = new Department();
        department.setName(departmentName);

        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> allDepartments() {
        return departmentRepository.findAll().stream()
                .map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());

    }
}
