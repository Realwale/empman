package org.waletech.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waletech.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
