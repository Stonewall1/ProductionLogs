package com.productionlogs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
    @NotBlank(message = "Field cant be empty!")
    private String equipmentName;
    @NotBlank(message = "Field cant be empty!")
    private String equipmentDescription;
}
