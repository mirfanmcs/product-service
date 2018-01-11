package com.irfanstore.product.service;

import com.irfanstore.product.dto.ProductPriceDto;
import org.springframework.stereotype.Component;

@Component
public class RestFeignClientFallback implements  RestFeignClient {

    @Override
    public ProductPriceDto getProductPrice(Long id) {
        return new ProductPriceDto();
    }
}
