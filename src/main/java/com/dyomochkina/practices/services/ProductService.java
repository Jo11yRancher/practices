package com.dyomochkina.practices.services;

import com.dyomochkina.practices.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();
    private long ID = 0;
    {
        productList.add(new Product(++ID, "IPhone 10", "Новісінький", 12500,"Житомир", "Ваня Карасьов"));
        productList.add(new Product(++ID, "Пральна машина", "Новісінький", 100500, "Житомир", "Ваня Карасьов"));
        productList.add(new Product(++ID, "Таблєткі", "Майже новісінькі", 300, "Житомир", "Ваня Карасьов"));
    }

    public List<Product> getProductList() {
        return productList;
    }
    public void saveProduct(Product product){
        product.setId(++ID);
        productList.add(product);
    }
    public void deleteProduct(Long id){
        productList.removeIf(product -> product.getId().equals(id));
    }

    public Object getProductById(Long id) {
        for (Product product:productList) {
            if (product.getId().equals(id))
                return product;
        }
        return null;
    }
}
