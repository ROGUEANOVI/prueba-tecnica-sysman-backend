package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.NumericConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.ValidationMessages;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialRequestDTO {

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.NAME_MAX_LENGTH, message = ValidationMessages.NAME_TOO_LONG)
    private String name;

    @Size(max = NumericConstants.DESCRIPTION_MAX_LENGTH, message = ValidationMessages.DESCRIPTION_TOO_LONG)
    private String description;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.TYPE_MAX_LENGTH, message = ValidationMessages.TYPE_TOO_LONG)
    private String type;

    @NotNull(message = ValidationMessages.FIELD_REQUIRED)
    @DecimalMin(value = NumericConstants.PRICE_MIN + "", inclusive = true, message = ValidationMessages.PRICE_MINIMUM)
    private BigDecimal price;

    @NotNull(message = ValidationMessages.FIELD_REQUIRED)
    private LocalDate purchaseDate;

    private LocalDate saleDate;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.STATUS_MAX_LENGTH, message = ValidationMessages.STATUS_TOO_LONG)
    private String status;

    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    private String cityCode;
}
