package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import javafx.scene.effect.SepiaTone;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductReposImpl implements IProductRepos {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();   //NOTE: lỗi: chưa khởi tạo map
        productMap.put(1, new Product(1, "Quạt Trần Hư", 230000, "Quạt treo trên trần", "Fuca"));
        productMap.put(2, new Product(2, "Quạt Trần Cũ", 230000, "Đồ second-hand", "Senko"));
        productMap.put(3, new Product(3, "Tivi", 230000, "Màn hình cong", "Sam Sung"));
        productMap.put(4, new Product(4, "Tủ lạnh", 230000, "280L", "Panasonic"));
        productMap.put(5, new Product(5, "Loa", 230000, "để bàn", "Fuca"));
    }

    @Override
    public void create(Product product) {
        Integer id = idAutoIncrement(productMap.size());
        product.setId(id);
        productMap.put(id, product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }


    //ham bổ trợ:
    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public Integer idAutoIncrement(int mapSize) {
        if (productMap.isEmpty()) {
            return 1;
        } else {
            return productMap.get(productMap.size()).getId() + 1;
        }
    }

    @Override
    public void update(Product product, Integer id) {
        productMap.put(id, product);
    }

    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String nameChar) {
        List<Product> searchByNameList = new ArrayList<>();
//        Set<Integer> set = productMap.keySet();
//        for (Integer key : set) {
//            if (productMap.get(key).getName().contains(nameChar)) {
//                searchByNameList.add(productMap.get(key));
//            }
//        }

        for (Product value : productMap.values()) {
            //đồng bộ  --> chữ thường
            String productNameLowerCase = value.getName().toLowerCase();
            String nameCharLowerCase = nameChar.toLowerCase();
            if (productNameLowerCase.contains(nameCharLowerCase)) {
                searchByNameList.add(value);
            }
        }
        return searchByNameList;
    }
}
