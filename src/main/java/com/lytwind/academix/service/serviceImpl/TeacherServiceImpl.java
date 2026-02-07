package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.dto.TeacherResponseDto;
import com.lytwind.academix.entity.Department;
import com.lytwind.academix.entity.Teacher;
import com.lytwind.academix.mapper.TeacherMapper;
import com.lytwind.academix.repository.DepartmentRepository;
import com.lytwind.academix.repository.TeacherRepository;
import com.lytwind.academix.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

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
}
