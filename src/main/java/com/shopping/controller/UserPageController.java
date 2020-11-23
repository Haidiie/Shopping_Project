/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.controller;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Heidar
 */
@Controller
@RequestMapping("/user")
public class UserPageController {
    
    @Autowired
    private ProductRepository prod;
    
    @Autowired
    private UserService userserv;
    
    @Autowired
    private OrderListRepository order;
    
    
     public List<Product> allProducts;
    
    
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
    
    @GetMapping("/product")
    public String showProductPage(Model model, String name){
        
        if(isNullOrEmpty(name)){
            model.addAttribute("products", prod.findAll());
        }else{
         List<Product> product = prod.findbynamehaving(name);
         allProducts = product;
         model.addAttribute("products", allProducts);
        }
        return "/user/product";
    }
    
    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(Model model, Principal p){
        
        User user = userserv.findByEmail(p.getName());
        model.addAttribute("orders", order.findByUserId(user.getId()));
//        model.addAttribute("orders", order.findAll());
        return "/user/shoppingcart";
    }
    
    
    @GetMapping("/process-product/{id}")
    public String postContact(@PathVariable("id") Long id, Model model, Principal p) {
     
            User user = userserv.findByEmail(p.getName());
            
            //order.setUser(user);
            //user.getProduct().add(product);
            //product.setUser(user);
             //prod.save(product);
             
             OrderList order1=new OrderList();
             Product product1 = prod.findById(id).get();
             
            order1.setName(product1.getName());
            order1.setPrice(product1.getPrice());
            order1.setUser(user);
           
            userserv.save(order1);
            
            
        return "redirect:/user/product";
    }
    
    
    @GetMapping("/product/delete/{id}")
    public String deleteProductFromCart(@PathVariable("id") long id) {
        
        
        
        userserv.deleteProduct(id);
        return "redirect:/user/shoppingcart";
    }
    
//    public String maxPrice (Model model){
//        int total = 
//        
//        return
//    }
//    
    
    
    
    
    
    
    
//    @PostMapping("/addtocart")
//    public String AddToCart(@ModelAttribute("addtocart") OrderList orderlist) {
//        
//
//            userserv.save(orderlist);
//
//            return "redirect:/";
//
//    }
    
//    @GetMapping("buy/{id}")
//	public String buy(@PathVariable("id") String id/*, HttpSession session*/) {
//
//
//			List<Product> cart = new ArrayList<Product>();
//                        prod
//			cart.add(new Product(prod.findById(id), 1));
//
//		return "redirect:/cart/index";
//	
//    
//}



}