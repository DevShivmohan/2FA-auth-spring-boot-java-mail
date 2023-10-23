package com.mail.fa.mail.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.shiv.mfa")
public class OneTimePasswordConfigurationProperties {

    private OTP otp = new OTP();

    @Data
    public class OTP {
        private Integer expirationMinutes;
    }

}