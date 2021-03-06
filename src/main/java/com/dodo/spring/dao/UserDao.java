package com.dodo.spring.dao;

import com.dodo.spring.model.User;

public interface UserDao {
  
  void save(User user);
  
  User findById(int id);
  
  User findBySSO(String sso);
  
}
