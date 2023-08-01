package pl.kowalczyk.ksb2week2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public ProductService() {
        Random random = new Random();
        int [] randomNumbers = random.ints(5, Constant.MIN_RANDOM_PRICE, Constant.MAX_RANDOM_PRICE + 1).toArray();
        products = new ArrayList<>();
        products.add(new Product("Gruszka", randomNumbers[0]));
        products.add(new Product("Pietruszka", randomNumbers[1]));
        products.add(new Product("Makaron", randomNumbers[2]));
        products.add(new Product("Olej", randomNumbers[3]));
        products.add(new Product("Cebula", randomNumbers[4]));
    }

    public double totalAmount() {
        double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
        return totalPrice;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


}
