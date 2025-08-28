package com.unisales.inventario;

public class Product {
    private static int totalProdutosCriados = 0;

    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        setPrice(price); 
        setQuantity(quantity); 
        totalProdutosCriados++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantity = quantity;
    }

    // Método estático
    public static int getTotalProductsCreated() {
        return totalProdutosCriados;
    }
}
