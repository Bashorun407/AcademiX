package com.lytwind.academix.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FeeView {
    BigDecimal getAmount();
    boolean getIsPaid();
    LocalDate getDueDate();
    StudentInfo getStudent();



    interface StudentInfo{
        String getFirstName();
        String getLastName();
        String getStudentRegNumber();
    }

}
