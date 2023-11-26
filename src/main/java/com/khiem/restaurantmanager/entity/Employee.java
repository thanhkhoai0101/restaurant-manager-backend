package com.khiem.restaurantmanager.entity;

import com.khiem.restaurantmanager.dto.EmployeeResponse;
import com.khiem.restaurantmanager.enums.EmployeeRole;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "employee", schema = "restaurant")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private EmployeeRole role;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    public EmployeeResponse toEmployeeResponse(){
        return EmployeeResponse.builder()
                .phoneNumber(getPhoneNumber())
                .avatar(getAvatar())
                .name(getFullName())
                .email(getEmail())
                .build();
    }
}