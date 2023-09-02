package pl.kowalczyk.ksb2week2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
@Profile("PRO")
public class ShopProVersion extends ShopPlusVersion{
    private final ProfileInfo profileInfo;

    public ShopProVersion(ProductService productService, ProfileInfo profileInfo) {
        super(productService, profileInfo);
        this.profileInfo = profileInfo;
    }

    public void fillCart() {
        super.fillCart();
        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Cost with discount: " + df.format(calculateDiscount()) + "zł");
    }

    public double calculateDiscount() {
        return super.calculateVat() - super.calculateVat() * profileInfo.getDiscount() / 100;
    }
}
