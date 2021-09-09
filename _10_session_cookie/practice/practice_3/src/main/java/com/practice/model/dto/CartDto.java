package com.practice.model.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<ProductDto, Integer>();  //chỉ cần 1 thuộc tính

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    //thêm vào giỏ hàng
    public void addCart(ProductDto productDto) {
        if (this.productMap.containsKey(productDto)) {
            productMap.put(productDto, productMap.get(productDto) + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }
    //chỉnh sửa giỏ hàng: giảm  (SL)
    public void subCart(ProductDto productDto) {
        if (this.productMap.containsKey(productDto)) {
            Integer value = productMap.get(productDto);
            if (value == 0) {
                productMap.remove(productDto);
            }else {
                productMap.put(productDto, productMap.get(productDto) - 1);
            }
        }
    }

    //findById:
    public Optional<ProductDto> findById(Long id) {
        Optional<ProductDto> productDto = Optional.empty();
        for (ProductDto item : this.productMap.keySet()) {
            if (item.getId().equals(id)) {
                productDto = Optional.of(item);
            }
        }
        return productDto;
    }

    //Delete:
    public void deleteById(Long id) {
        ProductDto productDto = findById(id).get();
        //xoa:
        this.productMap.remove(productDto);
    }

    //tính tổng tiền:
    public double sumPrice() {
        double sumPrice = 0;
       for (Map.Entry<ProductDto,Integer> item: productMap.entrySet()) {
           sumPrice += item.getKey().getPrice()*item.getValue();
       }
       return sumPrice;
    }
}
