package com.dodo.spring.dao;

import java.util.List;
import com.dodo.spring.model.Burger;
import com.dodo.spring.model.Menu;

public interface MenuDAO {
  
  public void addMenu(Menu m);
  
  public void updateMenu(Menu m);
  
  public List<Menu> listMenus();
  
  public List<Burger> listBurgers();
  
  public List<String> listBurgerNames();
  
  public Menu getMenuById(int id);
  
  public void removeMenu(int id);
  
  public Burger getBurgerById(int id);
  
}
