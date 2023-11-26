package com.khiem.restaurantmanager.enums;

public enum EmployeeRole {
    WAITER, CHEF, MANAGER, DEFAULT;

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
            case DEFAULT -> {
                return "Tài khoản thuộc nhà hàng";
            }
            default -> {
                return "";
            }
        }
    }
}
