package com.irfanstore.product.service;

import com.irfanstore.product.dto.ProductPriceDto;
import com.irfanstore.product.dto.ProductResponseDto;
import com.irfanstore.product.entity.Product;
import com.irfanstore.product.dto.ProductDto;
import com.irfanstore.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //****************  Either call using RestTemplate or Feign Client.
    //@Autowired
    //private RestTemplateClient productPriceClient;


    @Autowired
    private RestFeignClient productPriceClient;

   //*************************************************************************


    private ModelMapper modelMapper = new ModelMapper();

    public List<ProductResponseDto> getProducts()
    {
        List<Product> products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductResponseDto>>() {}.getType();
        List<ProductResponseDto> productsResponseDto =  modelMapper.map(products, listType);

        for (ProductResponseDto productResponseDto : productsResponseDto) {
            ProductPriceDto productPriceDto = getProductPrice(productResponseDto.getId());
                  productResponseDto.setProductPrice(productPriceDto);
        }
        return productsResponseDto;
    }

    public ProductResponseDto getProduct(long id) {
        Product product = productRepository.findOne(id);
        ProductPriceDto productPrice = getProductPrice(id);
        ProductResponseDto productResponseDto =  modelMapper.map(product, ProductResponseDto.class);
        productResponseDto.setProductPrice(productPrice);
        return productResponseDto;
    }



    public ProductResponseDto getProduct(String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        ProductResponseDto productResponseDto =  modelMapper.map(product, ProductResponseDto.class);


        ProductPriceDto productPriceDto = getProductPrice(productResponseDto.getId());
        productResponseDto.setProductPrice(productPriceDto);

        return productResponseDto;
    }

    public ProductResponseDto createOrUpdateProduct(ProductDto productDto) {
        Product product =  modelMapper.map(productDto, Product.class);

        Product productCreated = productRepository.save(product);

        ProductPriceDto productPriceDto = getProductPrice(productCreated.getId());
        ProductResponseDto productResponseDto =  modelMapper.map(productCreated, ProductResponseDto.class);

        productResponseDto.setProductPrice(productPriceDto);

        return productResponseDto;

    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);

    }

    private ProductPriceDto getProductPrice(long id) {
        try {
            ProductPriceDto productPriceDto = productPriceClient.getProductPrice(id);

            if (productPriceDto != null) {
               return productPriceDto;
           } else {
               return new ProductPriceDto();
           }
        }
       catch (org.springframework.web.client.HttpServerErrorException ex)
       {
           return new ProductPriceDto();
       }

    }

}
