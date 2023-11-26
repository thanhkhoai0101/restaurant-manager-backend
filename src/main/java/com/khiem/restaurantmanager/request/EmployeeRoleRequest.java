package com.khiem.restaurantmanager.request;

import com.khiem.restaurantmanager.enums.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRoleRequest {
    private long employeeId;
    private EmployeeRole employeeRole;
}
