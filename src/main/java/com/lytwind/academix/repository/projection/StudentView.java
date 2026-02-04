package com.lytwind.academix.repository.projection;

import java.time.LocalDate;

public interface StudentView {
    String getFirstName();
    String getLastName();
    String getEmail();
    ClassroomInfo getClassRoom();
    GuardianInfo getGuardian();

    interface ClassroomInfo{
        String getRoomNumber();
    }

    interface GuardianInfo{
        String getFirstName();
        String getLastName();
    }
}
