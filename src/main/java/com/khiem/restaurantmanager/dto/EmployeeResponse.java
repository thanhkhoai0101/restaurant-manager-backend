package com.khiem.restaurantmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponse {
    private String name;
    private String avatar;
    private String phoneNumber;
    private String email;
}
