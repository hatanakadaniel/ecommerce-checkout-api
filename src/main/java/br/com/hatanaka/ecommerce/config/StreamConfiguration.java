package br.com.hatanaka.ecommerce.config;

import br.com.hatanaka.ecommerce.stream.PurchaseSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(PurchaseSink.class)
public class StreamConfiguration {
}
