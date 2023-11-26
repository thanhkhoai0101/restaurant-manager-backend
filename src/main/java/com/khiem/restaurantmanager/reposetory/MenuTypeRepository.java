package com.khiem.restaurantmanager.reposetory;

import com.khiem.restaurantmanager.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuTypeRepository extends JpaRepository<MenuType, Integer>, JpaSpecificationExecutor<MenuType> {
}