package com.example.pms.model;

public class CartItem {
    private Long itemId;
    private int quantity;
    private String name;
    private double price;

    public CartItem(Long itemId, String name, double price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem() {}

    public Long getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setItemId(Long itemId) { this.itemId = itemId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}