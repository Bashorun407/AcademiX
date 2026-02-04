package com.lytwind.academix.service;

import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;

import java.util.List;
import java.util.Optional;

public interface GuardianService {
    Guardian createGuardian(Guardian guardian);
    Optional<Guardian> getGuardianById(Long id);
    List<Guardian> getAllGuardians();
    List<Student> getStudentsByGuardian(Long guardianId);
    Guardian updateGuardianContact(Long guardianId, String phone, String email);
}
