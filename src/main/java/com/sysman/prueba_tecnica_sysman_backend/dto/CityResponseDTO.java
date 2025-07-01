package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.CityConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CityResponseDTO {
    @Schema(description = CityConstants.CODE_DESCRIPTION, example = CityConstants.CODE_EXAMPLE)
    private String code;

    @Schema(description = CityConstants.NAME_DESCRIPTION, example = CityConstants.NAME_EXAMPLE)
    private String name;

    @Schema(description = CityConstants.DEPARTMENT_CODE_DESCRIPTION, example = CityConstants.DEPARTMENT_CODE_EXAMPLE)
    private String departmentCode;
}
