package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.ClassroomResponseDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.mapper.ClassroomMapper;
import com.lytwind.academix.repository.ClassroomRepository;
import com.lytwind.academix.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Override
    public ClassroomResponseDto classroomSetUp(String roomNumber, int capacity, int maxRoomCapacity) {
        if(classroomRepository.existsByRoomNumber(roomNumber))
            throw new IllegalArgumentException("Classroom already exists.");

        Classroom classroom = new Classroom();
        classroom.setRoomNumber(roomNumber);
        classroom.setCapacity(capacity);
        classroom.setMaxRoomCapacity(maxRoomCapacity);

        Classroom savedClass = classroomRepository.save(classroom);

        return ClassroomMapper.mapToClassroomDto(savedClass);
    }

    @Override
    public List<ClassroomResponseDto> allClasses() {
        return classroomRepository.findAll().stream()
                .map(ClassroomMapper::mapToClassroomDto).collect(Collectors.toList());
    }
}
