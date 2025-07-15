package com.example.pms.service;

import com.example.pms.model.CartItem;
import com.example.pms.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class CartService {

    private final List<CartItem> cart = new ArrayList<>();

    public List<CartItem> list() { return cart; }

    public void add(Item item) {
        Optional<CartItem> existing = cart.stream()
                .filter(ci -> ci.getItemId().equals(item.getId()))
                .findFirst();
        if (existing.isPresent()) {
            CartItem ci = existing.get();
            ci.setQuantity(ci.getQuantity() + 1);
        } else {
            cart.add(new CartItem(item.getId(), item.getName(), item.getPrice(), 1));
        }
    }

    public void remove(Long itemId) {
        cart.removeIf(ci -> ci.getItemId().equals(itemId));
    }

    public void clear() { cart.clear(); }
}