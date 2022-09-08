package com.example.challenge1.controller;

import com.example.challenge1.dao.ItemDao;
import com.example.challenge1.exception.ItemException;
import com.example.challenge1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/item/item{id}")
    public String getItem(@PathVariable String id) {
        try {
            return itemDao.getItem(id).toString();
        } catch (ItemException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/item")
    public String addItem(@RequestBody Item item) {
        try {
            itemDao.addItem(item);
            return "add item successfully";
        } catch (ItemException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/item/item")
    public List<Item> getItems() {
        return itemDao.getAllItems();
    }

    @PutMapping("/item/item")
    public String updateItem(@RequestBody Item item) {
        try {
            itemDao.updateItem(item);
            return "update successfully.";
        } catch (ItemException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/item/item{id}")
    public String deleteItem(@PathVariable String id) {
        try {
            itemDao.deleteItem(id);
            return "delete successfully.";
        } catch (ItemException e) {
            return e.getMessage();
        }
    }
}

