package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.ClassroomRequestDto;
import com.lytwind.academix.dto.ClassroomResponseDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.repository.projection.ClassroomView;

public class ClassroomMapper {

    //For Entity
    public static ClassroomResponseDto mapToClassroomDto(Classroom classroom){
        return new ClassroomResponseDto(
                classroom.getRoomNumber(),
                classroom.getCapacity(),
                classroom.getMaxRoomCapacity()
        );
    }

    //For Interface Projection
    public static ClassroomResponseDto mapToClassroomDto(ClassroomView classroomView){
        return new ClassroomResponseDto(
                classroomView.getRoomNumber(),
                classroomView.getCapacity(),
                classroomView.maxRoomCapacity()
        );
    }
}
