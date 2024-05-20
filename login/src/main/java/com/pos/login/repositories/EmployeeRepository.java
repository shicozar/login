package com.pos.login.repositories;

import com.pos.login.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Optional<Employee> findByEmployeeIdAndPassword(String employeeId, String password);
}
