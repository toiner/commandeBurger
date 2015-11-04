package com.dodo.spring.services;

import com.dodo.spring.model.User;

public interface UserService {
  
  void save(User user);
  
  User findById(int id);
  
  User findBySso(String sso);
  
}
