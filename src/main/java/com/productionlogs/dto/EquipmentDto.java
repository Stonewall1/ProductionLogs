package com.productionlogs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
    @NotBlank(message = "Field cant be empty!")
    private String equipmentName;
    @NotBlank(message = "Field cant be empty!")
    private String equipmentDescription;
}
