package com.shopping.service;

import com.shopping.model.User;


/**
 *
 * @author Heidar
 */
public interface UserService {
    
    public void save(User user);
    //public List <User> verify (String email, String password);
    public String enCryptedPassword(User user);
    
}
