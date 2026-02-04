package com.lytwind.academix.dto;

public record ClassroomDto(
        String roomNumber,
        int capacity,
        int maxRoomCapacity
) {
}
