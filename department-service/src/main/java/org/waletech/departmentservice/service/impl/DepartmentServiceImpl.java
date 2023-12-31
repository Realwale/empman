package org.waletech.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waletech.departmentservice.dto.DepartmentDTO;
import org.waletech.departmentservice.entity.Department;
import org.waletech.departmentservice.exception.DepartmentException;
import org.waletech.departmentservice.repository.DepartmentRepository;
import org.waletech.departmentservice.service.DepartmentService;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = departmentRepository.save(Department.builder()
                .id(departmentDTO.getId())
                .departmentName(departmentDTO.getDepartmentName())
                .departmentCode(departmentDTO.getDepartmentCode())
                .departmentDescription(departmentDTO.getDepartmentDescription())
                .build());

        return DepartmentDTO.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .departmentDescription(department.getDepartmentDescription())
                .build();
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(()-> new DepartmentException("Department not found with "+ departmentCode));

        return DepartmentDTO.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();
    }

    @Override
    public String deleteDepartmentByCode(String departmentCode) {
        departmentRepository.deleteByDepartmentCode(departmentCode);

        return "Deleted";
    }

}
