package com.lytwind.academix.service;

import com.lytwind.academix.dto.GuardianDto;
import com.lytwind.academix.dto.StudentResponseDto;

import java.util.List;

public interface GuardianService {
    GuardianDto createGuardian(GuardianDto guardianDto);
    //Optional<GuardianView> getGuardianById(Long id);
    List<GuardianDto> getAllGuardians();
    List<StudentResponseDto> getStudentsByGuardian(Long guardianId);
    GuardianDto updateGuardianContact(Long guardianId, String phone, String email, String profession);
}
