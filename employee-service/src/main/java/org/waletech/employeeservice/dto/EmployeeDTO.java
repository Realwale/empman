package org.waletech.employeeservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
