package com.kart.springboot.controller;

import com.kart.springboot.dto.ProductDTO;
import com.kart.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

import static com.kart.springboot.converter.ProductConverter.dtoToProduct;

@Controller
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public String createProduct(Map<String, Object> model) {

        model.put("productDTO", new ProductDTO());
        return "prodRegistrator";
    }

    @PostMapping("api/product/home")
    public String createProduct(@ModelAttribute("productDto") ProductDTO productDTO) {
        productService.createProduct(dtoToProduct(productDTO));
        return "redirect:api/product/list";
    }

    @PostMapping("api/product/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        productService.deleteProduct(Long.parseLong(id));
        return "redirect:api/product/list";
    }

    @GetMapping("api/product/list")
    public String getAll(Model model) {
        List<ProductDTO> productList = productService.getAll();
        model.addAttribute("ProductList", productList);
        return "prodList";
    }
}
