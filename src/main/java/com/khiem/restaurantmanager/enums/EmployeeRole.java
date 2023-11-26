package com.khiem.restaurantmanager.enums;

public enum EmployeeRole {
    WAITER, CHEF, MANAGER;

    public String text(){
        switch (this){
            case CHEF -> {
                return "Đầu bếp";
            }
            case WAITER -> {
                return "Nhân viên bồi bàn";
            }
            case MANAGER ->{
                return "Quản lý";
            }
            default -> {
                return "";
            }
        }
    }
}
