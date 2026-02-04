package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.GuardianRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.GuardianService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl implements GuardianService {
    private final GuardianRepository guardianRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public Guardian createGuardian(Guardian guardian) {
        // Business logic: check if email already exists before saving
        return guardianRepository.save(guardian);
    }

    @Override
    public Optional<Guardian> getGuardianById(Long id) {
        return guardianRepository.findById(id);
    }

    @Override
    public List<Guardian> getAllGuardians() {
        return guardianRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByGuardian(Long guardianId) {
        // Intermediate level: Business logic to find all children linked to this parent
        return studentRepository.findAll().stream()
                .filter(s -> s.getGuardian() != null && s.getGuardian().getId().equals(guardianId))
                .toList();
    }

    @Override
    @Transactional
    public Guardian updateGuardianContact(Long guardianId, String phone, String email) {
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new EntityNotFoundException("Guardian not found with ID: " + guardianId));

        // Update logic
        // If you were using the Senior-level 'ContactInfo' object,
        // you would update the embedded object here.

        //guardian.setPhoneNumber(phone);
        guardian.setEmail(email);

        return guardianRepository.save(guardian);
    }
}
