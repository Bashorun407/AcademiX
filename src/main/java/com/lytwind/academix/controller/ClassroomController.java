package com.lytwind.academix.controller;

import com.lytwind.academix.dto.ClassroomRequestDto;
import com.lytwind.academix.dto.ClassroomResponseDto;
import com.lytwind.academix.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping
    public ResponseEntity<ClassroomResponseDto> classroomSetUp(@RequestBody ClassroomRequestDto classroomRequestDto){
        ClassroomResponseDto classroom = classroomService.classroomSetUp(
                classroomRequestDto.roomNumber(),
                classroomRequestDto.capacity(),
                classroomRequestDto.maxRoomCapacity());
            return ResponseEntity.status(HttpStatus.CREATED).body(classroom);

    }

    @GetMapping("/all-classes")
    public ResponseEntity<List<ClassroomResponseDto>> allClasses(){
        List<ClassroomResponseDto> classroomList = classroomService.allClasses();

        return ResponseEntity.ok(classroomList);
    }
}
