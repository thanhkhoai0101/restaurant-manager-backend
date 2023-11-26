package com.khiem.restaurantmanager.reposetory;

import com.khiem.restaurantmanager.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TableRepository extends JpaRepository<Table, Integer>, JpaSpecificationExecutor<Table> {
}