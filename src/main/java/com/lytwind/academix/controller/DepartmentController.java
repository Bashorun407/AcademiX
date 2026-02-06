package com.lytwind.academix.controller;

import com.lytwind.academix.dto.DepartmentDto;
import com.lytwind.academix.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto department = departmentService.createDepartment(departmentDto.name());

        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping("/all-departments")
    public ResponseEntity<List<DepartmentDto>> allDepartments(){
        List<DepartmentDto> departments = departmentService.allDepartments();

        return ResponseEntity.ok(departments);
    }
}
