package metier;

import entity.Product;

public interface IProductMetier {
    double calculatePriceEuros(Product product);
    double calculatePriceCFA(Product product);
    double calculatePriceDollars(Product product);
}
