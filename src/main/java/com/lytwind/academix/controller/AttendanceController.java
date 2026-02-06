package com.lytwind.academix.controller;

import com.lytwind.academix.dto.AttendanceRequestDto;
import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public ResponseEntity<AttendanceResponseDto> recordAttendance(@RequestBody AttendanceRequestDto requestDto) {
        AttendanceResponseDto attendanceResponseDto = attendanceService.recordAttendance(
                requestDto.studentId(),
                requestDto.status()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceResponseDto);
    }

    @GetMapping("/student-attendance/{studentId}")
    public ResponseEntity<List<AttendanceResponseDto>> studentAttendance(@PathVariable Long studentId) {
        List<AttendanceResponseDto> responseDto = attendanceService.studentAttendance(studentId);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/attendance-with-date/{studentId}/{date}")
    public ResponseEntity<List<AttendanceResponseDto>> studentAttendanceWithDate(
            @PathVariable Long studentId,
            @PathVariable LocalDate date
    ){
        List<AttendanceResponseDto> responseDto = attendanceService.studentAttendanceWithDate(studentId, date);

        return ResponseEntity.ok(responseDto);
    }

}
