package org.waletech.departmentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name can not be empty")
    private String departmentName;

    @NotBlank(message = "Department code can not be empty")
    private String departmentCode;

    @Column(columnDefinition = "TEXT")
    private String departmentDescription;
}
