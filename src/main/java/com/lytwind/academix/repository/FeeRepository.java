package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Fee;
import com.lytwind.academix.repository.projection.FeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    @Query("SELECT f FROM Fee f WHERE f.isPaid = false AND f.student.id = :studentId")
    List<FeeView> findPendingFeesByStudent(Long studentId);


}
