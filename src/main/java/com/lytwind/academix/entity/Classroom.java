package com.lytwind.academix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;
    private int capacity;

    @Column(name = "max_room_capacity")
    private int maxRoomCapacity;
}
