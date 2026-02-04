package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.Department;
import com.lytwind.academix.entity.Teacher;
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
    public Teacher assignToDepartment(Long teacherId, Long deptId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();
        Department dept = departmentRepository.findById(deptId).orElseThrow();
        teacher.setDepartment(dept);
        return teacherRepository.save(teacher);
    }
}
