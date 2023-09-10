package org.waletech.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.waletech.employeeservice.dto.APIResponse;
import org.waletech.employeeservice.dto.DepartmentDTO;
import org.waletech.employeeservice.dto.EmployeeDTO;
import org.waletech.employeeservice.entity.Employee;
import org.waletech.employeeservice.exception.EmployeeException;
import org.waletech.employeeservice.repository.EmployeeRepository;
import org.waletech.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.save(Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .departmentCode(employeeDTO.getDepartmentCode())
                .email(employeeDTO.getEmail())
                .build());

        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .departmentCode(employee.getDepartmentCode())
                .email(employee.getEmail())
                .build();
    }

    @Override
    public APIResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EmployeeException("Employee not found with "+ employeeId));

        /*
        Using RestTemplate to establish communication between the two services
         */

      ResponseEntity<DepartmentDTO> response = restTemplate.getForEntity("http://localhost:8080/departments/"+employee.getDepartmentCode(),
                DepartmentDTO.class);

      DepartmentDTO departmentDTO = response.getBody();



        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode())
                .build();


        return APIResponse.builder()
                .department(departmentDTO)
                .employee(employeeDTO)
                .build();
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Deleted";
    }
}
