package com.shopping.controller;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    @GetMapping("/product")
    public String showProductPage(Model model, String name) {
        if (isNullOrEmpty(name)) {
            model.addAttribute("products", prod.findAll());
        } else {
            List<Product> product = prod.findbynamehaving(name);
            allProducts = product;
            model.addAttribute("products", allProducts);
        }
        return "/user/product";
    }

    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(Model model, Principal p) {
        User user = userserv.findByEmail(p.getName());
        model.addAttribute("orders", order.findByUserId(user.getId()));
        return "/user/shoppingcart";
    }

    @GetMapping("/process-product/{id}")
    public String postContact(@PathVariable("id") Long id, Model model, Principal p) {
        User user = userserv.findByEmail(p.getName());
        OrderList order1 = new OrderList();
        Product product1 = prod.findById(id).get();
        order1.setName(product1.getName());
        order1.setPrice(product1.getPrice());
        order1.setUsermail(user.getEmail());
        order1.setUseraddress(user.getAddress());
        order1.setUsercity(user.getCity());
        order1.setUser(user);
        userserv.save(order1);
        return "redirect:/user/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProductFromCart(@PathVariable("id") long id) {
        userserv.deleteProduct(id);
        return "redirect:/user/shoppingcart";
    }

    @GetMapping("checkout")
    public String checkout() {
        return "/user/checkout";
    }

}
