package com.lytwind.academix.service;

import com.lytwind.academix.dto.GuardianDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.projection.GuardianView;
import com.lytwind.academix.repository.projection.StudentView;

import java.util.List;
import java.util.Optional;

public interface GuardianService {
    GuardianDto createGuardian(GuardianDto guardianDto);
    //Optional<GuardianView> getGuardianById(Long id);
    List<GuardianDto> getAllGuardians();
    List<StudentResponseDto> getStudentsByGuardian(Long guardianId);
    GuardianDto updateGuardianContact(Long guardianId, String phone, String email, String profession);
}
