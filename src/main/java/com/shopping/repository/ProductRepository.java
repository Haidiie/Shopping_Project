/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.repository;

import com.shopping.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Heidar
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    
    @Query("select p from Product p where p.name like %:n%")
    public List<Product> findbynamehaving(@Param("n") String name);
    
}
