package com.dodo.spring.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.dodo.spring.model.Burger;
import com.dodo.spring.model.Menu;

@Repository
public class MenuDAOImpl implements MenuDAO {
  
  private static final Logger logger = LoggerFactory.getLogger(MenuDAOImpl.class);
  /** formatteur de la date yyyyMMdd */
  private static final SimpleDateFormat DATE_FORMATTEUR_DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy H'h'm");
  
  private SessionFactory sessionFactory;
  
  public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
  }
  
  @Override
  public void addMenu(Menu m) {
    Session session = this.sessionFactory.getCurrentSession();
    Calendar dateDuJour = Calendar.getInstance();
    m.setDateDeCommande(dateDuJour.getTime());
    session.persist(m);
    logger.info("Menu saved successfully, Menu Details=" + m);
  }
  
  @Override
  public void updateMenu(Menu m) {
    Session session = this.sessionFactory.getCurrentSession();
    Calendar dateDuJour = Calendar.getInstance();
    m.setDateDeCommande(dateDuJour.getTime());
    session.update(m);
    logger.info("Menu updated successfully, Menu Details=" + m);
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Menu> listMenus() {
    Session session = this.sessionFactory.getCurrentSession();
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR)) - 1);
    Date dateAComparer = (calendar.getTime());
    
    List<Menu> menusList = session.createQuery("from Menu").list();
    //    for (Menu m : menusList) {
    //      if (m.getDateDeCommande().after(dateAComparer)) {
    //        menusList.remove(m);
    //      }
    //      logger.info("Menu List::" + m);
    //    }
    return menusList;
  }
  
  /**
   * @return la liste des nom de burger présents en bases
   */
  @Override
  public List<String> listBurgerNames() {
    Session session = this.sessionFactory.getCurrentSession();
    String hql = "SELECT nom FROM Burger";
    Query query = session.createQuery(hql);
    List<String> burgerList = query.list();
    return burgerList;
  }
  
  /**
   * @return la liste de burger présente en base
   */
  @Override
  public List<Burger> listBurgers() {
    Session session = this.sessionFactory.getCurrentSession();
    List<Burger> burgersList = session.createQuery("from Burger").list();
    for (Burger b : burgersList) {
      logger.info("Burger List::" + b);
    }
    return burgersList;
  }
  
  @Override
  public Menu getMenuById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Menu m = (Menu) session.load(Menu.class, new Integer(id));
    logger.info("Menu loaded successfully, Menu details=" + m);
    return m;
  }
  
  @Override
  public void removeMenu(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Menu m = (Menu) session.load(Menu.class, new Integer(id));
    if (null != m) {
      session.delete(m);
    }
    logger.info("Menu deleted successfully, menu details=" + m);
  }
  
  @Override
  public Burger getBurgerById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    String hql = "FROM Burger WHERE id =" + id;
    Query query = session.createQuery(hql);
    return (Burger) query.list().get(0);
  }
  
}
