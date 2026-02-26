package com.lytwind.academix.controller;

import com.lytwind.academix.dto.DepartmentRequestDto;
import com.lytwind.academix.dto.DepartmentResponseDto;
import com.lytwind.academix.dto.DepartmentUpdateRequestDto;
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

        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDepartment(departmentRequestDto.name()));
    }

    @GetMapping("/all-departments")
    public ResponseEntity<List<DepartmentResponseDto>> allDepartments(){
        return ResponseEntity.ok(departmentService.allDepartments());
    }

    @PutMapping("/update-department/{departmentName}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @PathVariable String departmentName,
            @RequestBody DepartmentUpdateRequestDto updateRequestDto){

        return ResponseEntity.ok(departmentService.updateDepartment(
                departmentName,
                updateRequestDto.updateName()
                ));
    }

    @DeleteMapping("/remove-department/{departmentName}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String departmentName){
        return ResponseEntity.ok(departmentService.removeDepartment(departmentName));
    }
}
