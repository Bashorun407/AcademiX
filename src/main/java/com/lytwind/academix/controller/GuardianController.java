package com.lytwind.academix.controller;

import com.lytwind.academix.dto.GuardianDto;
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
    public ResponseEntity<GuardianDto> createGuardian(GuardianDto guardianDto){
        GuardianDto createdGuardian = guardianService.createGuardian(guardianDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuardian);
    }

    @GetMapping("/all-guardians")
    public ResponseEntity<List<GuardianDto>> getAllGuardians(){
        return ResponseEntity.ok(guardianService.getAllGuardians());
    }

    @GetMapping("/students-guardian/{guardianId}")
    public ResponseEntity<List<StudentResponseDto>> getStudentsByGuardian(@PathVariable Long guardianId){
        return ResponseEntity.ok(guardianService.getStudentsByGuardian(guardianId));
    }

    @GetMapping("/update-guardian/{guardianId}")
    public GuardianDto updateGuardianContact(@PathVariable Long guardianId, @RequestBody GuardianDto guardian){
        return guardianService.updateGuardianContact(guardianId, guardian.phoneNumber(),
                guardian.email(), guardian.profession());
    }
}
