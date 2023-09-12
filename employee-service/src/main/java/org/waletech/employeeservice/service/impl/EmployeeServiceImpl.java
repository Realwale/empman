package org.waletech.employeeservice.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.employeeservice.dto.APIResponse;
import org.waletech.employeeservice.dto.DepartmentDTO;
import org.waletech.employeeservice.dto.EmployeeDTO;
import org.waletech.employeeservice.entity.Employee;
import org.waletech.employeeservice.exception.EmployeeException;
import org.waletech.employeeservice.repository.EmployeeRepository;
import org.waletech.employeeservice.service.EmployeeService;
import org.waletech.employeeservice.service.OpenFeignClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

   //1. private final RestTemplate restTemplate;


   //2. private final WebClient webClient;    //Using webclient for communication

  //3. Using OpenFeignClient for communication

   private final OpenFeignClient openFeignClient;



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
        1. Using RestTemplate to establish communication between the two services

      ResponseEntity<DepartmentDTO> response = restTemplate.getForEntity("http://localhost:8080/departments/"+employee.getDepartmentCode(),
                DepartmentDTO.class);

      DepartmentDTO departmentDTO = response.getBody();
         */


        /*
        2. Using Webclient for communication

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();
         */

       DepartmentDTO departmentDTO = openFeignClient.getDepartmentByCode(employee.getDepartmentCode());

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
