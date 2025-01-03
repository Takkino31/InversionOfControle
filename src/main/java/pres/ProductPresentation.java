package pres;



import dao.IDao;
import dao.IProductDao;
import entity.Product;
import metier.IMetier;
import metier.IProductMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductPresentation {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("product.config.txt"));

            String productClassName = scanner.nextLine();

            Class<?> classProductDao = Class.forName(productClassName);
            System.out.println("La classe DAO utilise est : " + classProductDao);

            String metierClassName = scanner.nextLine();
            System.out.println("Le metier de la classe DAO utilise est : "+metierClassName);

//            Recuperation des produits
            IProductDao productDao = (IProductDao) classProductDao.getConstructor().newInstance();

            LinkedList<Product> products = productDao.getProducts();

            Class<?> classProductMetier = Class.forName(metierClassName);
            IProductMetier productMetier = (IProductMetier) classProductMetier.getConstructor(IProductDao.class).newInstance(productDao);

            Method getMetierCalculatePriceCFA = classProductMetier.getMethod("calculatePriceCFA", Product.class);
            Method getMetierCalculatePriceEuros = classProductMetier.getMethod("calculatePriceEuros", Product.class);
            Method getMetierCalculatePriceDollars = classProductMetier.getMethod("calculatePriceDollars", Product.class);



            for (Product product : products) {
                getMetierCalculatePriceCFA.invoke(productMetier,product);
                getMetierCalculatePriceEuros.invoke(productMetier,product);
                getMetierCalculatePriceDollars.invoke(productMetier,product);
                System.out.println(
                        "Product : " + product.getName() + "\n" +
                        "Description : " + product.getDescription() + "\n" +
                        "Price normale : " + product.getPrice() + "\n" +
                        "Price CFA: " + productMetier.calculatePriceCFA(product) + "\n" +
                        "Price EUROS: " + productMetier.calculatePriceEuros(product) + "\n" +
                        "Price DOLLAR: " + productMetier.calculatePriceDollars(product)
                );
                System.out.println("---------------");
            }

        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException();
        }
    }
}
