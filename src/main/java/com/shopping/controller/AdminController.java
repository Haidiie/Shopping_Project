/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.controller;

/**
 *
 * @author Heidar
 */
import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ProductRepository prod;
    
    @Autowired
    private UserService userserv;
    
    @Autowired
    private OrderListRepository order;
    
    @GetMapping("/admin_products")
    public String showAdminProductPage(Model model){
 
        model.addAttribute("admin_product", prod.findAll());
        
        return "/admin/admin_products";
    }
    
    @GetMapping("/product/deletebyadmin/{id}")
    public String deleteProductAdmin(@PathVariable("id") Long id, Model model) {
        userserv.deleteProductAdmin(id);
        return "redirect:/admin/admin_products";
    }
    
    
    @GetMapping("/add_products")
    public String showAddProductsPage(Model model) {

        return "/admin/add_products";

    }
    
    @GetMapping("/orders")
    public String showOrdersPage(Model model) {
        
        
        
        
        
        model.addAttribute("findorders", order.findAll());
        

        return "/admin/orders";

    }
    
    @GetMapping("/addproduct")
    public String AddProducts(Model model, Product product, Principal p) {

        User user = userserv.findByEmail(p.getName());
        product.setUser(user);
        
        model.addAttribute("title", prod.save(product));
        return "/admin/add_products";

    }
    
    
    
}