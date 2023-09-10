package org.waletech.employeeservice.service;

import org.waletech.employeeservice.dto.APIResponse;
import org.waletech.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    APIResponse getEmployeeById(Long employeeId);

    String deleteEmployeeById(Long employeeId);
}
