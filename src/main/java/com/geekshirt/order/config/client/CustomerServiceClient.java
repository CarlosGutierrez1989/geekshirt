package com.geekshirt.order.config.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerServiceClient {
    private RestTemplate restTemplate;

    public CustomerServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

}
