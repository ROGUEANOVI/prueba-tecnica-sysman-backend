package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.DepartmentConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartmentResponseDTO {
    @Schema(description = DepartmentConstants.CODE_DESCRIPTION, example = DepartmentConstants.CODE_EXAMPLE)
    private String code;

    @Schema(description = DepartmentConstants.NAME_DESCRIPTION, example = DepartmentConstants.NAME_EXAMPLE)
    private String name;
}
