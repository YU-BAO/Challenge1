package com.example.challenge1.dao;

import com.example.challenge1.exception.ItemException;
import com.example.challenge1.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDao {
    private static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("1", "item 1", "item 1 description", 12.0));
        items.add(new Item("2", "item 2", "item 2 description", 13.0));
        items.add(new Item("3", "item 3", "item 3 description", 14.0));
        items.add(new Item("4", "item 4", "item 4 description", 15.0));
        items.add(new Item("5", "item 5", "item 5 description", 16.0));
        items.add(new Item("6", "item 6", "item 6 description", 17.0));
    }

    public void addItem(Item item) throws ItemException {
        for (Item item1 : items) {
            if (item1.getId().equals(item.getId())) {
                throw new ItemException("There is already an item with id: " + item.getId());
            }
        }
        items.add(item);
    }

    public Item getItem(String id) throws ItemException {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        throw new ItemException("There is no items with specified id: " + id);
    }

    public List<Item> getAllItems() {
        return items;
    }

    public void updateItem(Item item) throws ItemException {
        for (Item item1 : items) {
            if (item.getId().equals(item1.getId())) {
                item1.setDesc(item.getDesc());
                item1.setName(item.getName());
                item1.setPrice(item.getPrice());
                return;
            }
        }
        throw new ItemException("There is no items with specified id: " + item.getId());
    }

    public void deleteItem(String id) throws ItemException {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                return;
            }
        }
        throw new ItemException("There is no items with specified id: " + id);
    }
}
