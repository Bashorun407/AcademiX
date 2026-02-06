package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.repository.projection.GuardianView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    boolean existsByEmail(String email);
    // Find a guardian by the student's ID
    Optional<GuardianView> findByFirstNameAndLastName(String firstName, String lastName);
}
