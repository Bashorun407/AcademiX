package com.lytwind.academix.controller;

import com.lytwind.academix.dto.DepartmentRequestDto;
import com.lytwind.academix.dto.DepartmentResponseDto;
import com.lytwind.academix.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){

        DepartmentResponseDto department = departmentService.createDepartment(departmentRequestDto.name());

        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping("/all-departments")
    public ResponseEntity<List<DepartmentResponseDto>> allDepartments(){
        List<DepartmentResponseDto> departments = departmentService.allDepartments();

        return ResponseEntity.ok(departments);
    }
}
