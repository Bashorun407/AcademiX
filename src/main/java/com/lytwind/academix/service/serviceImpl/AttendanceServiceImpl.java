package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.AttendanceResponseDto;
import com.lytwind.academix.entity.Attendance;
import com.lytwind.academix.entity.AttendanceStatus;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.mapper.AttendanceMapper;
import com.lytwind.academix.repository.AttendanceRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public AttendanceResponseDto recordAttendance(Long studentId, AttendanceStatus attendanceStatus) {
        //Check if attendance for a date has been registered already
        if(attendanceRepository.existsByStudentIdAndDate(studentId, LocalDate.now()))
            throw new IllegalArgumentException("Student's attendance has been taken already");

        Student student = studentRepository.getReferenceById(studentId);

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(attendanceStatus);

        Attendance markedAttendance = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceResponseDto(markedAttendance);
    }

    @Override
    public List<AttendanceResponseDto> studentAttendance(Long studentId) {
        return attendanceRepository.findByStudentId(studentId).stream()
                .map(AttendanceMapper::mapToAttendanceResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<AttendanceResponseDto> studentAttendanceWithDate(Long studentId, LocalDate date) {
        return attendanceRepository.findByStudentIdAndDate(studentId, date).stream()
                .map(AttendanceMapper::mapToAttendanceResponseDto).collect(Collectors.toList());
    }
}
