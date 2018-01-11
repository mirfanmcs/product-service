package com.irfanstore.product.service;

import com.irfanstore.product.dto.ProductPriceDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RibbonClient(name = "product-price-service")

//Direct service call
@FeignClient(value = "product-price-service", fallback = RestFeignClientFallback.class)

//Routing the request through API Gateway
//@FeignClient(value = "irfanstore-apigateway", fallback = RestFeignClientFallback.class)

public interface RestFeignClient {

    //Direct service call
    @RequestMapping(value="/api/productprice/{id}", method = RequestMethod.GET)

    //Routing the request through API Gateway
    //@RequestMapping(value="/product-price-service/api/productprice/{id}", method = RequestMethod.GET)
    ProductPriceDto getProductPrice(@PathVariable("id") Long id);
}