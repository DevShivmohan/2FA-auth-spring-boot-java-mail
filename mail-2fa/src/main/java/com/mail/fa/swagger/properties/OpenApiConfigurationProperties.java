package com.mail.fa.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.shiv.mfa")
public class OpenApiConfigurationProperties {

    private Swagger swagger = new Swagger();

    @Data
    public class Swagger {
        private String title;
        private String description;
        private String apiVersion;
        private Contact contact = new Contact();
        private Security security = new Security();

        @Data
        public class Contact {
            private String email;
            private String name;
            private String url;
        }

        @Data
        public class Security {
            private String name;
            private String scheme;
            private String bearerFormat;
        }
    }

}