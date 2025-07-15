package com.example.pms.controller;

import com.example.pms.model.Category;
import com.example.pms.model.Item;
import com.example.pms.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{category}")
    public List<Item> byCategory(@PathVariable String category) {
        Category cat = Category.valueOf(category.toUpperCase());
        return itemService.getByCategory(cat);
    }
}