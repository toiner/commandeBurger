package com.dodo.spring.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.dodo.spring.model.UserProfile;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {
  
  @Override
  @SuppressWarnings("unchecked")
  public List<UserProfile> findAll() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.asc("type"));
    return (List<UserProfile>) crit.list();
  }
  
  @Override
  public UserProfile findById(int id) {
    return getByKey(id);
  }
  
  @Override
  public UserProfile findByType(String type) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("type", type));
    return (UserProfile) crit.uniqueResult();
  }
}
