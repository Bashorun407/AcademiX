package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.GuardianDto;
import com.lytwind.academix.entity.Guardian;
import com.lytwind.academix.repository.projection.GuardianView;

public class GuardianMapper {

    //For Entity
    public static GuardianDto mapToGuardianDto(Guardian guardian){
        return new GuardianDto(
                guardian.getFirstName(),
                guardian.getLastName(),
                guardian.getEmail(),
                guardian.getProfession()
        );
    }

    //For Interface Projection
    public static GuardianDto mapToGuardianDto(GuardianView guardianView){
        return new GuardianDto(
                guardianView.getFirstName(),
                guardianView.getLastName(),
                guardianView.getEmail(),
                guardianView.getProfession()
        );
    }
}
