package org.waletech.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.waletech.employeeservice.dto.DepartmentDTO;

@FeignClient(url = "http://localhost:8080/", value = "DEPARTMENT-SERVICE")
public interface OpenFeignClient {

    @GetMapping(value = "departments/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("code") String departmentCode);

}