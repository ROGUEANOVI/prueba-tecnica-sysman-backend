package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.MaterialConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.NumericConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialRequestDTO {

    @Schema(description = MaterialConstants.NAME_DESCRIPTION, example = MaterialConstants.NAME_EXAMPLE)
    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.NAME_MAX_LENGTH, message = ValidationMessages.NAME_TOO_LONG)
    private String name;

    @Schema(description = MaterialConstants.DESCRIPTION_DESCRIPTION, example = MaterialConstants.DESCRIPTION_EXAMPLE)
    @Size(max = NumericConstants.DESCRIPTION_MAX_LENGTH, message = ValidationMessages.DESCRIPTION_TOO_LONG)
    private String description;

    @Schema(description = MaterialConstants.TYPE_DESCRIPTION, example = MaterialConstants.TYPE_EXAMPLE)
    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.TYPE_MAX_LENGTH, message = ValidationMessages.TYPE_TOO_LONG)
    private String type;

    @Schema(description = MaterialConstants.PRICE_DESCRIPTION, example = MaterialConstants.PRICE_EXAMPLE)
    @NotNull(message = ValidationMessages.FIELD_REQUIRED)
    @DecimalMin(value = NumericConstants.PRICE_MIN + "", inclusive = true, message = ValidationMessages.PRICE_MINIMUM)
    private BigDecimal price;

    @Schema(description = MaterialConstants.PURCHASE_DATE_DESCRIPTION, example = MaterialConstants.PURCHASE_DATE_EXAMPLE)
    @NotNull(message = ValidationMessages.FIELD_REQUIRED)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate purchaseDate;

    @Schema(description = MaterialConstants.SALE_DATE_DESCRIPTION, example = MaterialConstants.SALE_DATE_EXAMPLE)
    private LocalDate saleDate;

    @Schema(description = MaterialConstants.STATUS_DESCRIPTION, example = MaterialConstants.STATUS_EXAMPLE)
    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    @Size(max = NumericConstants.STATUS_MAX_LENGTH, message = ValidationMessages.STATUS_TOO_LONG)
    private String status;

    @Schema(description = MaterialConstants.CITY_CODE_DESCRIPTION, example = MaterialConstants.CITY_CODE_EXAMPLE)
    @NotBlank(message = ValidationMessages.FIELD_REQUIRED)
    private String cityCode;
}
