package com.dodo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dodo.spring.dao.UserDao;
import com.dodo.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserDao dao;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Override
  public void save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    dao.save(user);
  }
  
  @Override
  public User findById(int id) {
    return dao.findById(id);
  }
  
  @Override
  public User findBySso(String sso) {
    return dao.findBySSO(sso);
  }
  
}
