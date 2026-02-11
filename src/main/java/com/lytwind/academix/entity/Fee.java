package com.lytwind.academix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Field 1

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; //Field 2

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal amount; // Field 3

    private boolean isPaid; //Field 4

    @Lob
    private String description; // Field 5: Large text mapping

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus status; // Field 6: Enum mapping

    @Column(name = "reference_number", nullable = false, unique = true, updatable = false)
    private String referenceNumber; // Field 7

    private boolean isScholarshipApplicable; // Field 8

    private LocalDate dueDate; // Field 9

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // Field 10

    @UpdateTimestamp
    private LocalDateTime updatedAt; // Field 11: Automated Audit field

    @Version
    private Integer version; // Field 12: Optimistic locking (Very Advanced!)
}
