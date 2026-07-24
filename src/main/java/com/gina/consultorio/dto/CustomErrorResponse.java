package com.gina.consultorio.dto;

public record CustomErrorResponse(
    int codigo,
    String mensaje
) { }
