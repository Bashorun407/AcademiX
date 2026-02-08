package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.GuardianResponseDto;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.repository.projection.GuardianView;

public class GuardianMapper {

    //For Entity
    public static GuardianResponseDto mapToGuardianDto(Guardian guardian){
        return new GuardianResponseDto(
                guardian.getFirstName(),
                guardian.getLastName(),
                guardian.getEmail(),
                guardian.getPhoneNumber(),
                guardian.getProfession()
        );
    }

    //For Interface Projection
    public static GuardianResponseDto mapToGuardianDto(GuardianView guardianView){
        return new GuardianResponseDto(
                guardianView.getFirstName(),
                guardianView.getLastName(),
                guardianView.getEmail(),
                guardianView.getPhoneNumber(),
                guardianView.getProfession()
        );
    }
}
