package pl.kowalczyk.ksb2week2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("profile-info")
@Getter
@Setter
public class ProfileInfo {

    private int vat;
    private int discount;
}
