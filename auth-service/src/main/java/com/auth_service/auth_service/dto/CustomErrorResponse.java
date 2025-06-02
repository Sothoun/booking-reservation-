package com.auth_service.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
