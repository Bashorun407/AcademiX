package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Find a classroom by its room number
    Optional<Classroom> findByRoomNumber(String roomNumber);
}
