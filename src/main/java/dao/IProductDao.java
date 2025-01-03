package dao;

import entity.Product;

import java.util.LinkedList;

public interface IProductDao {

    LinkedList<Product> getProducts();

}
