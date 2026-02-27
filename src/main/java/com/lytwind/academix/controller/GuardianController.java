package com.lytwind.academix.controller;

import com.lytwind.academix.dto.GuardianRequestDto;
import com.lytwind.academix.dto.GuardianResponseDto;
import com.lytwind.academix.dto.GuardianUpdateRequestDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardian")
public class GuardianController {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @PostMapping
    public ResponseEntity<GuardianResponseDto> createGuardian(@RequestBody GuardianRequestDto guardianRequestDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(guardianService.createGuardian(
                guardianRequestDto.firstName(),
                guardianRequestDto.lastName(),
                guardianRequestDto.email(),
                guardianRequestDto.phoneNumber(),
                guardianRequestDto.profession()));
    }

    @GetMapping("/all-guardians")
    public ResponseEntity<List<GuardianResponseDto>> getAllGuardians(){
        return ResponseEntity.ok(guardianService.getAllGuardians());
    }

    @GetMapping("/students/{guardianId}")
    public ResponseEntity<List<StudentResponseDto>> getStudentsByGuardian(@PathVariable Long guardianId){
        return ResponseEntity.ok(guardianService.getStudentsByGuardian(guardianId));
    }

    @PutMapping("/update/{guardianId}")
    public ResponseEntity<GuardianResponseDto> updateGuardianContact(@PathVariable Long guardianId, @RequestBody GuardianUpdateRequestDto guardian){
        return ResponseEntity.ok(guardianService.updateGuardian(guardianId, guardian.phoneNumber(),
                guardian.email(), guardian.profession()));
    }

    @DeleteMapping("/delete/{guardianId}")
    public ResponseEntity<String> removeGuardian(@PathVariable Long guardianId){
        return ResponseEntity.ok(guardianService.removeGuardian(guardianId));
    }
}
