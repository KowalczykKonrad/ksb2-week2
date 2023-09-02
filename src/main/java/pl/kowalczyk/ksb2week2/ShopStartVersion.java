package pl.kowalczyk.ksb2week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Scanner;

@Component
@Profile("START")
public class ShopStartVersion {

    private final ProductService productService;

    @Autowired
    public ShopStartVersion(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillCart() {
        final DecimalFormat df = new DecimalFormat("0.00");

        String answer;
        do {
            System.out.println("You already have " + productService.getProducts().size() + " products in your cart for  " + productService.totalAmount() + " zł.");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Would you like to add another product? Y/N");
            answer = scanner.nextLine();

            while(!Constant.POSITIVE_ANSWERS.contains(answer) && !Constant.NEGATIVE_ANSWERS.contains(answer)) {
                System.out.println("Please type Y/N, y/n, YES/NO, or yes/no");
                answer = scanner.nextLine();
            }

            if(Constant.POSITIVE_ANSWERS.contains(answer)) {
                System.out.println("Provide product name: ");
                String name = scanner.nextLine();
                System.out.println("Provide product price: ");
                double price = scanner.nextDouble();

                productService.addProduct(new Product(name, price));
            }

        } while(!Constant.NEGATIVE_ANSWERS.contains(answer));

        System.out.println("Your bill:");
        productService.getProducts().forEach(product -> System.out.println(product.toString()));
        System.out.println("Total cost: " + df.format(productService.totalAmount()) + "zł");
    }
}
