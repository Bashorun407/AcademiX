package com.lytwind.academix.service;

import com.lytwind.academix.dto.ClassroomResponseDto;

import java.util.List;

public interface ClassroomService {
    ClassroomResponseDto classroomSetUp(String roomNumber, int capacity, int maxRoomCapacity);
    List<ClassroomResponseDto> allClasses();
}
