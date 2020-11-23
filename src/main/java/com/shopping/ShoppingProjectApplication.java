package com.shopping;

import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProjectApplication.class, args);
	}
        
        
//                @Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
//
//			User user = new User();
//                        
//                        Product product = new Product();
//                        repository.save(new User("admin@hotmail.com", "123456","Legendvägen 19","Stockholm",true,"ROLE_ADMIN"));
//
//		};
//	}
        
//        @Bean
//	public CommandLineRunner demo(ProductRepository repository) {
//		return (args) -> {
//
//			
//                        Product product = new Product();
//                        repository.save(new Product("fifa", 400, "fotbollsspel", "bil.jpg"));
//                        repository.save(new Product("Call of Duty", 300, "krigsspel", "oken.jpg"));
//                        repository.save(new Product("mario", 500, "äventyrsspel", "vagg.jpg"));
//                        
//                        
//                 
//		};
//	}
        
        

}
