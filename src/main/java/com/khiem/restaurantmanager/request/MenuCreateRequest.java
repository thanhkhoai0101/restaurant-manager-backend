package com.khiem.restaurantmanager.request;

import com.khiem.restaurantmanager.entity.MenuType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuCreateRequest {
    private String name;
    private Integer unitPrice;
    private String status;
    private MenuType idMenuType;
}
