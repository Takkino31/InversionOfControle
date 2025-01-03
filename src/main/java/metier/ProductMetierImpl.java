package metier;

import dao.IProductDao;
import entity.Product;

public class ProductMetierImpl implements IProductMetier{

    private IProductDao productDao;

    public ProductMetierImpl(IProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductMetierImpl() {
    }

    @Override
    public double calculatePriceEuros(Product product) {
        return product.getPrice()*650;
    }

    @Override
    public double calculatePriceCFA(Product product) {
        return product.getPrice()*100;
    }

    @Override
    public double calculatePriceDollars(Product product) {
        return product.getPrice()*500;
    }

    public void setDaoProduct(IProductDao daoProduct) {
        this.productDao = daoProduct;
    }
}
