package org.waletech.departmentservice.dto.response;

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
    private LocalDateTime timestamp;
    private String path;
}
