package com.luluzsp.travel.controller;

import com.luluzsp.Utils.UUIDUtils;
import com.luluzsp.travel.entity.Product;
import com.luluzsp.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/21 17:04
 * @description：ProductController
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return  mv;
    }

    @RequestMapping("/save")
    public String  saveProduct(Product product){
        product.setId(UUIDUtils.generateID());
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
