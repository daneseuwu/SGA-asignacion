package com.dbz.SGA_asignacion.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareerDTO {

    private Long idCareer;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Duration is required")
    private Integer duration;

    @NotBlank(message = "faculty is required")
    private String faculty;

    @NotBlank(message = "Active is required")
    private Boolean active;
}
