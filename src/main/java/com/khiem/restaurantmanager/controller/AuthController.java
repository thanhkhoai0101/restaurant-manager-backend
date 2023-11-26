package com.khiem.restaurantmanager.controller;

import com.khiem.restaurantmanager.dto.LoginResponse;
import com.khiem.restaurantmanager.entity.Employee;
import com.khiem.restaurantmanager.entity.LoginSession;
import com.khiem.restaurantmanager.reposetory.EmployeeRepository;
import com.khiem.restaurantmanager.reposetory.LoginSessionRepository;
import com.khiem.restaurantmanager.request.LoginRequest;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final LoginSessionRepository loginSessionRepository;

    public AuthController(PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository, LoginSessionRepository loginSessionRepository) {
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;
        this.loginSessionRepository = loginSessionRepository;
    }

    @PostMapping("login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        Optional<Employee> user = employeeRepository.findByUsername(request.getUsername());
        if (user.isEmpty()) {
            return null;
        }

        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        LoginSession session = new LoginSession();
        session.setEmployee(user.get());
        session.setToken(token);
        loginSessionRepository.save(session);

        return LoginResponse.builder()
                .token(token)
                .employee(session.getEmployee().toEmployeeResponse())
                .build();
    }

    @GetMapping("check-login")
    public boolean checkLogin() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Employee) {
            System.out.println("zô rồi!!");
            return true;
        }
        System.out.println("Thoát");
        return false;

    }

    @DeleteMapping("logout")
    public void logout(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");

        if (token != null) {
            String rawToken = token.substring("Bearer ".length());
            loginSessionRepository.deleteById(loginSessionRepository.findByToken(rawToken).get().getId());
        }
    }
}