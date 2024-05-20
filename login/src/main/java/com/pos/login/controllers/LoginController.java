package com.pos.login.controllers;

import com.pos.login.entities.Employee;
import com.pos.login.services.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private Authentication authentication;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @PostMapping
    public ResponseEntity<?> login(@RequestParam String employeeId, @RequestParam String password) {
        logger.info("Login attempt for employee ID: {}", employeeId);
        Optional<Employee> authenticatedEmployee = authentication.authenticate(employeeId, password);

        if (authenticatedEmployee.isPresent()) {
            EmployeeDTO employeeDTO = new EmployeeDTO(authenticatedEmployee.get());
            logger.info("Login successful for employee ID: {}", employeeId);
            return ResponseEntity.ok(employeeDTO);
        } else {
            logger.warn("Login failed for employee ID: {}", employeeId);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }

    static class EmployeeDTO {
        private String emplyoeeId;
        private String name;
        private String position;
        private Long storeId;

        public EmployeeDTO(Employee employee) {
            this.emplyoeeId = employee.getEmployeeId();
            this.name = employee.getName();
            this.position = employee.getPosition();
            this.storeId = employee.getStoreId();
        }

        public String getEmplyoeeId() {
            return emplyoeeId;
        }

        public void setEmplyoeeIdId(String emplyoeeId) {
            this.emplyoeeId = emplyoeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Long getStoreId() {
            return storeId;
        }

        public void setStoreId(Long storeId) {
            this.storeId = storeId;
        }
    }
}
