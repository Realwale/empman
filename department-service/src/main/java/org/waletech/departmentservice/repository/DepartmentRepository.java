package org.waletech.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
