package br.com.hatanaka.ecommerce.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PurchaseSink {

    String INPUT = "purchase-created";

    @Input(PurchaseSink.INPUT)
    SubscribableChannel input();
}
