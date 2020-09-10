package com.hatanaka.ecommerce.checkout.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtil {

    public UUID createUUID() {
        return UUID.randomUUID();
    }
}
