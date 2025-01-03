package dao;

import entity.Product;

import java.util.LinkedList;

public class ProductDaoImpl implements IProductDao{
    @Override
    public LinkedList<Product> getProducts() {
        LinkedList<Product> products = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product(i+1, "Produit "+(i+1), (int) (Math.random() * 10) * (int) (Math.random() * 10) + 1, "Je suis le produit "+ (i+1));
            products.add(product);
        }
        return products;
    }
}
