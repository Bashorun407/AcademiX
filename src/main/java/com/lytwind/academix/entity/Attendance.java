package com.lytwind.academix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    @ManyToOne
    private Student student;


}
