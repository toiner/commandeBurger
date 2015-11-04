package com.dodo.spring.services;

import java.util.List;
import com.dodo.spring.model.UserProfile;

public interface UserProfileService {
  
  List<UserProfile> findAll();
  
  UserProfile findByType(String type);
  
  UserProfile findById(int id);
}
