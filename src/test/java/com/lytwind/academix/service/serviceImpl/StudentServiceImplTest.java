package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.StudentUpdateRequestDto;
import com.lytwind.academix.entity.Classroom;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.ClassroomRepository;
import com.lytwind.academix.repository.GuardianRepository;
import com.lytwind.academix.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private GuardianRepository guardianRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void shouldRegisterStudentSuccessfully() {
        Guardian guardian = new Guardian();
        guardian.setId(1L);

        Classroom classroom = new Classroom();
        classroom.setRoomNumber("A1");
        classroom.setCapacity(10);
        classroom.setMaxRoomCapacity(20);

        when(studentRepository.existsByEmailAndLastName(anyString(), anyString()))
                .thenReturn(false);

        when(guardianRepository.findById(1L))
                .thenReturn(Optional.of(guardian));

        when(classroomRepository.findByRoomNumber("A1"))
                .thenReturn(Optional.of(classroom));

        // ✅ Fix: explicitly cast the argument
        when(studentRepository.save(Mockito.<Student>any()))
                .thenAnswer(invocation -> (Student) invocation.getArgument(0));

        var result = studentService.registerStudent(
                "John", "Doe", "john@mail.com",
                "123456", LocalDate.now(), "A1", 1L
        );

        assertNotNull(result);

        // separate verify statements
        verify(studentRepository, times(1)).save(Mockito.<Student>any());
        verify(classroomRepository, times(1)).save(Mockito.<Classroom>any());
    }

    @Test
    void shouldThrowIfStudentAlreadyExists() {
        when(studentRepository.existsByEmailAndLastName(anyString(), anyString()))
                .thenReturn(true);

        assertThrows(RuntimeException.class, () ->
                studentService.registerStudent(
                        "John", "Doe", "email",
                        "123", LocalDate.now(), "A1", 1L
                ));
    }

    @Test
    void shouldThrowIfClassroomIsFull() {
        Guardian guardian = new Guardian();

        Classroom classroom = new Classroom();
        classroom.setCapacity(20);
        classroom.setMaxRoomCapacity(20);

        when(studentRepository.existsByEmailAndLastName(anyString(), anyString()))
                .thenReturn(false);

        when(guardianRepository.findById(anyLong()))
                .thenReturn(Optional.of(guardian));

        when(classroomRepository.findByRoomNumber(anyString()))
                .thenReturn(Optional.of(classroom));

        assertThrows(RuntimeException.class, () ->
                studentService.registerStudent(
                        "John", "Doe", "email",
                        "123", LocalDate.now(), "A1", 1L
                ));
    }

    @Test
    void shouldUpdateStudent() {
        // Create student
        Student student = new Student();
        student.setStudentRegNumber("REG-1");

        //Assign a guardian to avoid NullPointerException
        Guardian guardian = new Guardian();
        guardian.setId(1L);
        guardian.setFirstName("Mary");
        guardian.setLastName("Smith");
        student.setGuardian(guardian); // crucial line

        // Create classroom
        Classroom classroom = new Classroom();

        // Update DTO
        StudentUpdateRequestDto dto = new StudentUpdateRequestDto("new@mail.com", "999", "B1");

        // Mock repository calls
        when(studentRepository.findByStudentRegNumber("REG-1"))
                .thenReturn(Optional.of(student));

        when(classroomRepository.findByRoomNumber("B1"))
                .thenReturn(Optional.of(classroom));

        when(studentRepository.save(Mockito.<Student>any()))
                .thenAnswer(invocation -> (Student) invocation.getArgument(0));

        // Call service
        var result = studentService.updateStudent("REG-1", dto);

        // Assert changes
        assertEquals("new@mail.com", student.getEmail());
    }
}
