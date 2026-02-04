package com.lytwind.academix.service.serviceImpl;

import com.lytwind.academix.entity.Fee;
import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.FeeRepository;
import com.lytwind.academix.repository.StudentRepository;
import com.lytwind.academix.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final FeeRepository feeRepository;
    private final StudentRepository studentRepository;

    @Override
    public Fee issueInvoice(Long studentId, BigDecimal amount) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Fee fee = new Fee();
        fee.setStudent(student);
        fee.setAmount(amount);
        fee.setPaid(false);
        fee.setDueDate(LocalDate.now().plusDays(14));
        return feeRepository.save(fee);
    }

    @Override
    public Fee markAsPaid(Long feeId) {
        Fee fee = feeRepository.findById(feeId).orElseThrow();
        fee.setPaid(true);
        return feeRepository.save(fee);
    }
}
