package com.unisales;

import com.unisales.inventario.Product;

public class ProductManager {
    public static void main(String[] args) {
        Product produto1 = new Product(1, "Notebook", 3500.00, 10);

        System.out.println("Nome: " + produto1.getName());
        System.out.println("Preço: R$ " + produto1.getPrice());
        System.out.println("Quantidade: " + produto1.getQuantity());

        produto1.setPrice(3600.00);
        produto1.setQuantity(12);  

        System.out.println("Preço atualizado: R$ " + produto1.getPrice());
        System.out.println("Quantidade atualizada: " + produto1.getQuantity());
        System.out.println("Total de produtos criados: " + Product.getTotalProductsCreated());
    }
}
