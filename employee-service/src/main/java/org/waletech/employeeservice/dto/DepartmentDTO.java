package org.waletech.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
