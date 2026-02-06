package com.lytwind.academix.service;

import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.dto.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    ClassroomDto classroomSetUp(String roomNumber, int capacity, int maxRoomCapacity);
    List<ClassroomDto> allClasses();
}
