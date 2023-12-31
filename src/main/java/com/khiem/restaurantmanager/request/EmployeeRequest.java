package com.khiem.restaurantmanager.request;

import com.khiem.restaurantmanager.enums.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String fullName;
    private String avatar;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private EmployeeRole employeeRole;
}
