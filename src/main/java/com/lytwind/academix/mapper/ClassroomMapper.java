package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.ClassroomDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.repository.projection.ClassroomView;

public class ClassroomMapper {

    //For Entity
    public static ClassroomDto mapToClassroomDto(Classroom classroom){
        return new ClassroomDto(
                classroom.getRoomNumber(),
                classroom.getCapacity(),
                classroom.getMaxRoomCapacity()
        );
    }

    //For Interface Projection
    public static ClassroomDto mapToClassroomDto(ClassroomView classroomView){
        return new ClassroomDto(
                classroomView.getRoomNumber(),
                classroomView.getCapacity(),
                classroomView.maxRoomCapacity()
        );
    }
}
