package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.DepartmentResponseDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.mapper.DepartmentMapper;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponseDto createDepartment(String departmentName) {
        if(departmentRepository.existsByNameIgnoreCase(departmentName))
            throw new IllegalArgumentException("Department already exists.");

        Department department = new Department();
        department.setName(departmentName);

        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public List<DepartmentResponseDto> allDepartments() {
        return departmentRepository.findAll().stream()
                .map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());

    }

    @Override
    public DepartmentResponseDto updateDepartment(String departmentName, String updateName) {
        Department departmentToBeUpdated = departmentRepository.findByNameIgnoreCase(departmentName)
                .orElseThrow(()-> new IllegalArgumentException("department with name: " + departmentName + " does not exist."));
        departmentToBeUpdated.setName(updateName);
        Department savedDepartment = departmentRepository.save(departmentToBeUpdated);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public String removeDepartment(String departmentName) {
        Department departmentToBeRemoved = departmentRepository.findByNameIgnoreCase(departmentName)
                .orElseThrow(()-> new IllegalArgumentException("department with name: " + departmentName + " does not exist."));

        departmentRepository.delete(departmentToBeRemoved);

        return "Department is successfully removed.";
    }
}
