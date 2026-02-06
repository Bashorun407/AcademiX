package com.lytwind.academix.controller;

import com.lytwind.academix.dto.ClassroomDto;
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
    public ResponseEntity<ClassroomDto> classroomSetUp(@RequestBody ClassroomDto classroomDto){
        ClassroomDto classroom = classroomService.classroomSetUp(
                classroomDto.roomNumber(),
                classroomDto.capacity(),
                classroomDto.maxRoomCapacity());
            return ResponseEntity.status(HttpStatus.CREATED).body(classroom);

    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> allClasses(){
        List<ClassroomDto> classroomDtoList = classroomService.allClasses();

        return ResponseEntity.ok(classroomDtoList);
    }
}
