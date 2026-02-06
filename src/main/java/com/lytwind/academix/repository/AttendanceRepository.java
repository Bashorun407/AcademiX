package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Attendance;
import com.lytwind.academix.repository.projection.AttendanceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByStudentIdAndDate(Long studentId, LocalDate date);
    List<AttendanceView> findByStudentId(Long studentId);
    List<AttendanceView> findByStudentIdAndDate(Long studentId, LocalDate date);
}
