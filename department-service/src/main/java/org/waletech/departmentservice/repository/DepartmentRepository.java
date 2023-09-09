package org.waletech.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.waletech.departmentservice.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);

    @Transactional
    void deleteByDepartmentCode(String departmentCode);
}
