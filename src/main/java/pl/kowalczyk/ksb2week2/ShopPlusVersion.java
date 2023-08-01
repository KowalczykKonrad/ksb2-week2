package pl.kowalczyk.ksb2week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
@Profile("PLUS")
public class ShopPlusVersion extends ShopStartVersion{

    private ProductService productService;
    private ProfileInfo profileInfo;

    @Autowired
    public ShopPlusVersion(ProductService productService, ProfileInfo profileInfo) {
        super(productService);
        this.productService = productService;
        this.profileInfo = profileInfo;
    }

    public void fillCart() {
        super.fillCart();
        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Cost with vat: " + df.format(calculateVat()) + "zł");
    }

    public double calculateVat() {
        return productService.totalAmount() + productService.totalAmount() * profileInfo.getVat() / 100;
    }
}
