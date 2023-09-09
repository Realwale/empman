package org.waletech.departmentservice.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTO {

    private Long id;

    private String departmentName;

    private String departmentCode;

    private String departmentDescription;
}
