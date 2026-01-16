package com.lytwind.academix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
    @Id
    private String courseCode;
    private String title;
    private int creditUnits;

    @ManyToOne
    private Department department;
}
