package com.dodo.spring.dao;

import java.util.List;
import com.dodo.spring.model.UserProfile;

public interface UserProfileDao {
  
  List<UserProfile> findAll();
  
  UserProfile findByType(String type);
  
  UserProfile findById(int id);
}
