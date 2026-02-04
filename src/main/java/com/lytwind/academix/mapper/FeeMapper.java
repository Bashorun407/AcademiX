package com.lytwind.academix.mapper;

import com.lytwind.academix.dto.FeeResponseDto;
import com.lytwind.academix.entity.Fee;
import com.lytwind.academix.repository.projection.FeeView;

public class FeeMapper {

    //For Entity
    public static FeeResponseDto mapToFeeResponseDto(Fee fee){
        return new FeeResponseDto(
                fee.getAmount(),
                fee.isPaid(),
                fee.getDueDate(),
                fee.getStudent().getFirstName(),
                fee.getStudent().getLastName(),
                fee.getStudent().getStudentRegNumber()
        );
    }

    //For Interface Projection
    public static FeeResponseDto mapToFeeResponseDto(FeeView feeView){
        return new FeeResponseDto(
                feeView.getAmount(),
                feeView.getIsPaid(),
                feeView.getDueDate(),
                feeView.getStudent().getFirstName(),
                feeView.getStudent().getLastName(),
                feeView.getStudent().getStudentRegNumber()
        );
    }
}
