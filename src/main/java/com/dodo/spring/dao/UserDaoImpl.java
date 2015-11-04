package com.dodo.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.dodo.spring.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
  
  @Override
  public void save(User user) {
    persist(user);
  }
  
  @Override
  public User findById(int id) {
    return getByKey(id);
  }
  
  @Override
  public User findBySSO(String sso) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("ssoId", sso));
    return (User) crit.uniqueResult();
  }
  
}
