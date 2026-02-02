package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.repository.projection.ClassroomView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Find a classroom by its room number
    Optional<ClassroomView> findByRoomNumber(String roomNumber);
}
