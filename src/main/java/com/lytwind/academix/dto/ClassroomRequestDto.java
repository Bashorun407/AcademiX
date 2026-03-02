package com.lytwind.academix.dto;

public record ClassroomRequestDto(
        String roomNumber,
        int maxRoomCapacity
) {
    public ClassroomRequestDto{
        if(roomNumber == null){
            throw new IllegalArgumentException("Room number cannot be null");
        }

        if(maxRoomCapacity < 0 || maxRoomCapacity == 0 ){
            throw new IllegalArgumentException("Maximum capacity cannot be negative or zero (0)!");
        }
    }
}
