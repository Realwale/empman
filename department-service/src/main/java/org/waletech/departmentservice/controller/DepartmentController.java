package org.waletech.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.waletech.departmentservice.dto.DepartmentDTO;
import org.waletech.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@Validated @RequestBody DepartmentDTO departmentDTO){
       return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("code") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteDepartmentByDepartmentCode(@PathVariable("code") String departmentCode){
        return new ResponseEntity<>(departmentService.deleteDepartmentByCode(departmentCode), HttpStatus.OK);
    }
}
