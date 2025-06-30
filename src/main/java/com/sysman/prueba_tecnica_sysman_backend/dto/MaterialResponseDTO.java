package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.MaterialConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialResponseDTO {

    @Schema(description = MaterialConstants.ID_DESCRIPTION, example = MaterialConstants.ID_EXAMPLE)
    private Long id;

    @Schema(description = MaterialConstants.NAME_DESCRIPTION, example = MaterialConstants.NAME_EXAMPLE)
    private String name;

    @Schema(description = MaterialConstants.DESCRIPTION_DESCRIPTION, example = MaterialConstants.DESCRIPTION_EXAMPLE)
    private String description;

    @Schema(description = MaterialConstants.TYPE_DESCRIPTION, example = MaterialConstants.TYPE_EXAMPLE)
    private String type;

    @Schema(description = MaterialConstants.PRICE_DESCRIPTION, example = MaterialConstants.PRICE_EXAMPLE)
    private BigDecimal price;

    @Schema(description = MaterialConstants.PURCHASE_DATE_DESCRIPTION, example = MaterialConstants.PURCHASE_DATE_EXAMPLE)
    private LocalDate purchaseDate;

    @Schema(description = MaterialConstants.SALE_DATE_DESCRIPTION, example = MaterialConstants.SALE_DATE_EXAMPLE)
    private LocalDate saleDate;

    @Schema(description = MaterialConstants.STATUS_DESCRIPTION, example = MaterialConstants.STATUS_EXAMPLE)
    private String status;

    private CityDTO city;
}
