package org.waletech.departmentservice.service;

import org.waletech.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String departmentCode);

    String deleteDepartmentByCode(String departmentCode);
}
