package com.pos.login.services;

import com.pos.login.entities.Employee;
import com.pos.login.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class Authentication{
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(Authentication.class);

    public Optional<Employee> authenticate(String employeeId, String password) {
        logger.info("Attempting to authenticate employee with ID: {}", employeeId);
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndPassword(employeeId, password);
        if (employee.isPresent()) {
            logger.info("Authentication successful for employee ID: {}", employeeId);
        } else {
            logger.warn("Authentication failed for employee ID: {}", employeeId);
        }
        return employee;
    }
}
