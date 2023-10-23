package com.mail.fa.security.utility;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@UtilityClass
public class SecurityUtils {

    public static User convert(com.mail.fa.entity.User user) {
        return new User(user.getEmailId(), user.getPassword(), List.of());
    }

}