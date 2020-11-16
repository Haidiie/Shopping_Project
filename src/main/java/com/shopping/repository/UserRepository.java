package com.shopping.repository;

import com.shopping.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Heidar
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    
    //public List<User> findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    
}
