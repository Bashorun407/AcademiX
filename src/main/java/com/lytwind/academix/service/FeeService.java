package com.lytwind.academix.service;

import com.lytwind.academix.entity.Fee;

import java.math.BigDecimal;

public interface FeeService {
    Fee issueInvoice(Long studentId, BigDecimal amount);
    Fee markAsPaid(Long feeId);
}
