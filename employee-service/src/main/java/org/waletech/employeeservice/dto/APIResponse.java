package org.waletech.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {

    private EmployeeDTO employee;

    private DepartmentDTO department;
}
