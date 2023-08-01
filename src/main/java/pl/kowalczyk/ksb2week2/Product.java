package pl.kowalczyk.ksb2week2;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;

        if(price > 0.0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be positive number");
        }
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        return "Product name: " + name + " | Price: " + df.format(price) + "zł";
    }
}
