package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.GuardianRequestDto;
import com.lytwind.academix.dto.GuardianResponseDto;
import com.lytwind.academix.dto.StudentResponseDto;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.mapper.GuardianMapper;
import com.lytwind.academix.mapper.StudentMapper;
import com.lytwind.academix.repository.GuardianRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.GuardianService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl implements GuardianService {
    private final GuardianRepository guardianRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public GuardianResponseDto createGuardian(String firstName, String lastName, String email,
                                              String phoneNumber, String profession) {
        if(guardianRepository.existsByEmail(email))
            throw new RuntimeException("Guardian with this email exist.");

        Guardian guardian = new Guardian();
        guardian.setFirstName(guardian.getFirstName());
        guardian.setLastName(guardian.getLastName());
        guardian.setEmail(guardian.getEmail());
        guardian.setPhoneNumber(guardian.getPhoneNumber());
        guardian.setProfession(guardian.getProfession());

        // Business logic: check if email already exists before saving
        return GuardianMapper.mapToGuardianDto(guardianRepository.save(guardian));
    }

//    @Override
//    public Optional<GuardianView> getGuardianById(Long id) {
//        return guardianRepository.findById(id);
//    }

    @Override
    public List<GuardianResponseDto> getAllGuardians() {
        return guardianRepository.findAll().stream()
                .map(GuardianMapper::mapToGuardianDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDto> getStudentsByGuardian(Long guardianId) {
        // Intermediate level: Business logic to find all children linked to this parent
        return studentRepository.findAll().stream()
                .filter(s -> s.getGuardian() != null && s.getGuardian().getId().equals(guardianId))
                .map(StudentMapper::mapToStudentResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public GuardianResponseDto updateGuardianContact(Long guardianId, String phone, String email, String profession) {
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new EntityNotFoundException("Guardian not found with ID: " + guardianId));

        // Update logic
        // If you were using the Senior-level 'ContactInfo' object,
        // you would update the embedded object here.

        guardian.setPhoneNumber(phone);
        guardian.setEmail(email);
        guardian.setProfession(profession);

        Guardian updatedGuardian = guardianRepository.save(guardian);
        return GuardianMapper.mapToGuardianDto(updatedGuardian);
    }
}
