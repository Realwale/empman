package org.waletech.employeeservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    private int errorCode;
    private String message;
    private String path;
    private LocalDateTime timestamp;
}
