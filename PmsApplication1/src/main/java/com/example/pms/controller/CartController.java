package com.example.pms.controller;

import com.example.pms.model.CartItem;
import com.example.pms.service.CartService;
import com.example.pms.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final ItemService itemService;

    public CartController(CartService cartService, ItemService itemService) {
        this.cartService = cartService;
        this.itemService = itemService;
    }

    @GetMapping
    public List<CartItem> list() { return cartService.list(); }

    @PostMapping("/{itemId}")
    public ResponseEntity<?> add(@PathVariable Long itemId) {
        cartService.add(itemService.findById(itemId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> remove(@PathVariable Long itemId) {
        cartService.remove(itemId);
        return ResponseEntity.noContent().build();
    }
}