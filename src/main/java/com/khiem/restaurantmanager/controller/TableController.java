package com.khiem.restaurantmanager.controller;

import com.khiem.restaurantmanager.entity.Table;
import com.khiem.restaurantmanager.reposetory.TableRepository;
import com.khiem.restaurantmanager.request.TableCreateRequest;
import com.khiem.restaurantmanager.request.TableUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("table")
public class TableController {
    public final TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping("")
    public List<Table> list() {
        return tableRepository.findAll();
    }

    @PutMapping("create")
    public Table create(@RequestBody TableCreateRequest request) {
        Table table = new Table();
        table.setCapacity(request.getCapacity());
        return tableRepository.save(table);
    }

    @PostMapping("update/{id}")
    public Table update(@PathVariable int id, @RequestBody TableUpdateRequest request) {
        Optional<Table> optionalTable = tableRepository.findById(id);
        Table table = optionalTable.orElse(null);
        if (table == null) {
            return null;
        }
        table.setCapacity(request.getCapacity());
        return tableRepository.save(table);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Table> optionalTable = tableRepository.findById(id);
        Table table = optionalTable.orElse(null);
        if (table == null) {
            return "Loi";
        }
        tableRepository.deleteById(id);
        return "Ok";
    }
}
