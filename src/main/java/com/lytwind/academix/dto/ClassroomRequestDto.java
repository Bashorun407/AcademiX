package com.lytwind.academix.dto;

public record ClassroomRequestDto(
        String roomNumber,
        int capacity,
        int maxRoomCapacity
) {
    public ClassroomRequestDto{
        if(roomNumber == null){
            throw new IllegalArgumentException("Room number cannot be null");
        }

        if(capacity < 0){
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        if(maxRoomCapacity < 0 || maxRoomCapacity == 0 ){
            throw new IllegalArgumentException("Maximum capacity cannot be negative or zero (0)!");
        }
    }
}
