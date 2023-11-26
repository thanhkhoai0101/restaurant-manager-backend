package com.khiem.restaurantmanager.controller;

import com.khiem.restaurantmanager.dto.EmployeeResponse;
import com.khiem.restaurantmanager.entity.Employee;
import com.khiem.restaurantmanager.reposetory.EmployeeRepository;
import com.khiem.restaurantmanager.request.EmployeeRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    public EmployeeController(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")
    public List<EmployeeResponse> list() {
        return employeeRepository.findAll().stream().map(Employee::toEmployeeResponse).toList();
    }

    @GetMapping("{username}")
    public EmployeeResponse get(@PathVariable String username) {
        return employeeRepository.findByUsername(username).get().toEmployeeResponse();
    }

    @PostMapping("/register")
    public EmployeeResponse register(@RequestBody EmployeeRequest request) {
        if (employeeRepository.findByUsername(request.getUsername()).isPresent()) {
            return null;
        }

        Employee employee = new Employee();

        employee.setUsername(request.getUsername());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setAvatar(request.getAvatar());
        employee.setFullName(request.getFullName());

        return employeeRepository.save(employee).toEmployeeResponse();
    }

    @PutMapping("{id}")
    public EmployeeResponse update(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        if (employeeRepository.findById(id).isEmpty()) {
            return null;
        }
        Employee employee = employeeRepository.findById(id).get();

        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setAvatar(request.getAvatar());
        employee.setFullName(request.getFullName());

        return employeeRepository.save(employee).toEmployeeResponse();
    }
}