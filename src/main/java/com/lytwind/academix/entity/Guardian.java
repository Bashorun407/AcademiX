package com.lytwind.academix.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guardian extends Person{
    private String profession;
}
