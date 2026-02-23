package com.lytwind.academix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Student extends Person{
    private String studentRegNumber;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "guardian_id")
    private Guardian guardian;

    @OneToOne
    private Classroom classroom;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
