package com.irfanstore.product.service;

import com.irfanstore.product.dto.ProductPriceDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@EnableDiscoveryClient
public class RestTemplateClient {
    private static final String PRODUCT_SERVICE = "product-price-service";


    @Bean
    @LoadBalanced  //<-This internally uses Ribbon.
    RestTemplate rest() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

  /*  @HystrixCommand(fallbackMethod = "getBackupGuide")
    public String getGuide() {
        //One way of getting the URL through the service registry.
        return restTemplate.getForObject("https://company/available", String.class);
    }

    String getBackupGuide() {
        return "None available! Your backup guide is: Cookie";
    }
*/


    @HystrixCommand(fallbackMethod = "getProductPriceDefault")
    public ProductPriceDto getProductPrice(long id) {

        //Another way of getting the URL through the serivce registry.
        URI serviceUri =  UriComponentsBuilder.fromUriString("//" + PRODUCT_SERVICE + "/api/productprice/" + id).build().toUri();

            return restTemplate.getForObject(serviceUri, ProductPriceDto.class);
    }

    ProductPriceDto getProductPriceDefault(long id) {
        return new ProductPriceDto();
    }

}
