package com.irfanstore.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class App 
{
    public static void main(String[] args) {
            SpringApplication.run(App.class, args);
    }

    //Capturing all the traces. Can customize what we want to trace.
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}

