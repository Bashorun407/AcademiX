package com.lytwind.academix.dto;

public record ClassroomUpdateRequestDto(
        int capacity,
        int maxRoomCapacity
) {
    public ClassroomUpdateRequestDto{
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity cannot be less than or equal to 0");
        }

        if(maxRoomCapacity <= 0){
            throw new IllegalArgumentException("Maximum room capacity cannot be less than or equal to 0");
        }
    }
}
