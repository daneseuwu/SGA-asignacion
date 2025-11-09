package com.dbz.SGA_asignacion.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeResponse {
    private String message;
    private Object data;
}
