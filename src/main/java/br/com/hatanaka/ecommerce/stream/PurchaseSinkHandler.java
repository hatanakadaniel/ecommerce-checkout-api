package br.com.hatanaka.ecommerce.stream;

import org.springframework.cloud.stream.annotation.StreamListener;

public class PurchaseSinkHandler {

    @StreamListener(PurchaseSink.INPUT)
    public void processMessage(String message) {

    }
}
