package com.lytwind.academix.controller;

import com.lytwind.academix.dto.ClassroomRequestDto;
import com.lytwind.academix.dto.ClassroomResponseDto;
import com.lytwind.academix.dto.ClassroomUpdateRequestDto;
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

            return ResponseEntity.status(HttpStatus.CREATED).body( classroomService.classroomSetUp(
                    classroomRequestDto.roomNumber(),
                    classroomRequestDto.capacity(),
                    classroomRequestDto.maxRoomCapacity()));

    }

    @GetMapping("/all-classes")
    public ResponseEntity<List<ClassroomResponseDto>> allClasses(){

        return ResponseEntity.ok(classroomService.allClasses());
    }

    @PutMapping("/update-classroom/{roomNumber}")
    public ResponseEntity<ClassroomResponseDto> updateClassroom(@PathVariable String roomNumber,
                                                                @RequestBody ClassroomUpdateRequestDto classroomRequestDto){


        return ResponseEntity.ok(classroomService.updateClassroom(
                roomNumber,
                classroomRequestDto.capacity(),
                classroomRequestDto.maxRoomCapacity()));
    }

    @DeleteMapping("/remove-classroom/{classroomNumber}")
    public ResponseEntity<String> deleteClassroom(@PathVariable String classroomNumber){
        classroomService.deleteClassroom(classroomNumber);

        return ResponseEntity.ok("Classroom has been successfully deleted");
    }
}
