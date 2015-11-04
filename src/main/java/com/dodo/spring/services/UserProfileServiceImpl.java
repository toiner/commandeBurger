package com.dodo.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dodo.spring.dao.UserProfileDao;
import com.dodo.spring.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
  
  @Autowired
  UserProfileDao dao;
  
  @Override
  public List<UserProfile> findAll() {
    return dao.findAll();
  }
  
  @Override
  public UserProfile findByType(String type) {
    return dao.findByType(type);
  }
  
  @Override
  public UserProfile findById(int id) {
    return dao.findById(id);
  }
}
