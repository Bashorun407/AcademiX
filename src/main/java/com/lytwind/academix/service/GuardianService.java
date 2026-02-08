package com.lytwind.academix.service;

import com.lytwind.academix.dto.GuardianRequestDto;
import com.lytwind.academix.dto.GuardianResponseDto;
import com.lytwind.academix.dto.StudentResponseDto;

import java.util.List;

public interface GuardianService {
    GuardianResponseDto createGuardian(GuardianRequestDto guardianRequestDto);
    //Optional<GuardianView> getGuardianById(Long id);
    List<GuardianResponseDto> getAllGuardians();
    List<StudentResponseDto> getStudentsByGuardian(Long guardianId);
    GuardianResponseDto updateGuardianContact(Long guardianId, String phone, String email, String profession);
}
