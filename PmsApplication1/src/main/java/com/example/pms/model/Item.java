package com.example.pms.model;

public class Item {
    private Long id;
    private String name;
    private String imageUrl;
    private Category category;
    private double price;

    public Item(Long id, String name, String imageUrl, Category category, double price) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
    }

    public Item() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return imageUrl; }
    public Category getCategory() { return category; }
    public double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setCategory(Category category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
}