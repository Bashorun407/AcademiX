package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.TeacherResponseDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.entity.Teacher;
import com.lytwind.academix.mapper.TeacherMapper;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.repository.TeacherRepository;
import com.lytwind.academix.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public TeacherResponseDto createTeacher(String firstName, String lastName, String employeeId,
                                            String email, String phoneNumber, String departmentName) {
        if(teacherRepository.existsByEmployeeId(employeeId))
            throw new RuntimeException("Employee with this ID already exists.");

        Department department = departmentRepository.findByNameIgnoreCase(departmentName)
                .orElseThrow(()-> new RuntimeException("Department with this department name: " + " does not exist."));

        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmployeeId(employeeId);
        teacher.setEmail(email);
        teacher.setPhoneNumber(phoneNumber);
        teacher.setDepartment(department);

        return TeacherMapper.mapToTeacherResponseDto(
                teacherRepository.save(teacher)
        );
    }

    @Override
    public List<TeacherResponseDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(TeacherMapper::mapToTeacherResponseDto).toList();
    }

    @Override
    public TeacherResponseDto assignToDepartment(Long teacherId, Long deptId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow();
        Department department = departmentRepository.findById(deptId)
                .orElseThrow();
        teacher.setDepartment(department);
        Teacher updatedTeacher = teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherResponseDto(updatedTeacher);
    }

    @Override
    public String removeTeacher(Long teacherId) {

        Teacher teacher = teacherRepository.getReferenceById(teacherId);
        teacherRepository.delete(teacher);

        return "Teacher details removed.";
    }
}
