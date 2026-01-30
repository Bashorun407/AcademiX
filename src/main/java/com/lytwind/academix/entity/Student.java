package com.lytwind.academix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
}
