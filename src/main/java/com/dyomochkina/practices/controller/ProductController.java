package com.dyomochkina.practices.controller;


import com.dyomochkina.practices.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/yuschenko")

    public String products(Model model){
        model.addAttribute("productList", productService.getProductList());
        return "products";
    }
    @GetMapping("/")
    public String returnIndex(Model model){
        model.addAttribute("productList", productService.getProductList());
        return "index";
    }
    @GetMapping("/product/{id}")
    private String productInfo(Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }
}
