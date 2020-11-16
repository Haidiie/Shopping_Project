/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Heidar
 */
@Controller
@RequestMapping("/user")
public class UserPageController {
    
    @GetMapping("/product")
    public String showProductPage(){
        
        
        return "/user/product";
    }
    
    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(){
        
        
        return "/user/shoppingcart";
    }
    
}
