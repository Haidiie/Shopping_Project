/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.repository;

import com.shopping.model.OrderList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Heidar
 */
@Repository
public interface OrderListRepository extends CrudRepository<OrderList,Long>{
    
    public List<OrderList>findByUserId(long id);
    
    
    //public List<OrderList>findByUserEmail(String email);
}
