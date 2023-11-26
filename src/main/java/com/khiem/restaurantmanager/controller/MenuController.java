package com.khiem.restaurantmanager.controller;

import com.khiem.restaurantmanager.entity.Menu;
import com.khiem.restaurantmanager.reposetory.MenuRepository;
import com.khiem.restaurantmanager.request.MenuCreateRequest;
import com.khiem.restaurantmanager.request.MenuUpdateRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menu")
public class MenuController {
    public final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("")
    public List<Menu> list() {
        return menuRepository.findAll();
    }

    @PostMapping("create")
    public Menu create(@RequestBody MenuCreateRequest request) {
        Menu menu = new Menu();
        menu.setName(request.getName());
        menu.setUnitPrice(request.getUnitPrice());
        menu.setStatus(request.getStatus());
        menu.setIdMenuType(request.getIdMenuType());

        return menuRepository.save(menu);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        Menu menu = optionalMenu.orElse(null);
        if (menu == null) {
            return "Không tìm thấy món ăn";
        }
        menuRepository.deleteById(id);
        return "Ok";
    }

    @PutMapping("update/{id}")
    public Menu update(@PathVariable int id, @RequestBody MenuUpdateRequest request){
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        Menu menu = optionalMenu.orElse(null);
        if (menu == null) {
            return null;
        }
        menu.setName(request.getName());
        menu.setUnitPrice(request.getUnitPrice());
        menu.setStatus(request.getStatus());
        menu.setIdMenuType(request.getIdMenuType());

        return menuRepository.save(menu);

    }


}
