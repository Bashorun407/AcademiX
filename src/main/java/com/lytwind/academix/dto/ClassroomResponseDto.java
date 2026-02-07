package com.lytwind.academix.dto;

public record ClassroomResponseDto(
        String roomNumber,
        int capacity,
        int maxRoomCapacity
) {
}
