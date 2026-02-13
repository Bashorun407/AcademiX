package com.lytwind.academix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    private boolean isPaid;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus status;

    @Column(name = "reference_number", nullable = false, unique = true, updatable = false)
    private String referenceNumber;

    private boolean isScholarshipApplicable;

    private LocalDate dueDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Version
    private Integer version;
}
