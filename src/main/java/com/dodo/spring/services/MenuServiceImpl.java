package com.dodo.spring.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dodo.spring.dao.MenuDAO;
import com.dodo.spring.model.Burger;
import com.dodo.spring.model.Menu;

@Service
public class MenuServiceImpl implements MenuService {
  
  private MenuDAO menuDAO;
  
  public void setMenuDAO(MenuDAO menuDAO) {
    this.menuDAO = menuDAO;
  }
  
  @Override
  @Transactional
  public void addMenu(Menu m) {
    this.menuDAO.addMenu(m);
  }
  
  @Override
  @Transactional
  public void updateMenu(Menu m) {
    this.menuDAO.updateMenu(m);
  }
  
  @Override
  @Transactional
  public List<Menu> listMenus() {
    return this.menuDAO.listMenus();
  }
  
  @Override
  @Transactional
  public Menu getMenuById(int id) {
    return this.menuDAO.getMenuById(id);
  }
  
  @Override
  @Transactional
  public void removeMenu(int id) {
    this.menuDAO.removeMenu(id);
  }
  
  @Override
  @Transactional
  public List<String> listBurgerNames() {
    return this.menuDAO.listBurgerNames();
  }
  
  @Override
  @Transactional
  public List<Burger> listBurgers() {
    return this.menuDAO.listBurgers();
  }
  
}
