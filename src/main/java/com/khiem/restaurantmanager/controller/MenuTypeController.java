package com.khiem.restaurantmanager.controller;

import com.khiem.restaurantmanager.entity.MenuType;
import com.khiem.restaurantmanager.reposetory.MenuTypeRepository;
import com.khiem.restaurantmanager.request.MenuCreateRequest;
import com.khiem.restaurantmanager.request.MenuTypeCreateRequest;
import com.khiem.restaurantmanager.request.MenuTypeUpdateRequest;
import com.khiem.restaurantmanager.request.MenuUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menu-type")
public class MenuTypeController {

    public final MenuTypeRepository menuTypeRepository;

    public MenuTypeController(MenuTypeRepository menuTypeRepository) {
        this.menuTypeRepository = menuTypeRepository;
    }


    @GetMapping("")
    public List<MenuType> list() {
        return menuTypeRepository.findAll();
    }

    @PostMapping("create")
    public MenuType create(@RequestBody MenuTypeCreateRequest request) {
        MenuType menuType = new MenuType();
        menuType.setName(request.getName());
        return menuTypeRepository.save(menuType);
    }

    @PutMapping("update/{id}")
    public MenuType update(@PathVariable int id, @RequestBody MenuTypeUpdateRequest request) {
        Optional<MenuType> optionalMenuType = menuTypeRepository.findById(id);
        MenuType menuType = optionalMenuType.orElse(null);
        if (menuType == null) {
            return null;
        }
        menuType.setName(request.getName());
        return menuTypeRepository.save(menuType);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<MenuType> optionalMenuType = menuTypeRepository.findById(id);
        MenuType menuType = optionalMenuType.orElse(null);
        if (menuType == null) {
            return "Khong tim thay";
        }
        menuTypeRepository.deleteById(id);
        return "Ok";
    }


}
