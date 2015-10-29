package com.dodo.spring.controller;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dodo.spring.model.Menu;
import com.dodo.spring.services.MenuService;

@Controller
public class MenuController {
  
  private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
  private static final String[] tableauDeBurger = { "Véritable", "Véritable Hallal", "Mont d'or", "Savoyard", "Jurassien's", "Burger du moment",
                                                   "Spécial Hongrois" };
  private static final List<String> listeDesNomsDeBurger = Arrays.asList(tableauDeBurger);
  private static final String[] tableauDeBoisson = { "Coca", "Orangina", "7up", "Tropico", "Coca zero", "Dr pepper", "Eau (pour les faibles)", "Autre" };
  private static final List<String> listeDesBoissons = Arrays.asList(tableauDeBoisson);
  private MenuService menuService;
  
  @Autowired(required = true)
  @Qualifier(value = "menuService")
  public void setMenuService(MenuService ms) {
    this.menuService = ms;
  }
  
  @RequestMapping(value = "/menus", method = RequestMethod.GET)
  public String listMenus(Model model) {
    logger.debug("entrée dans listMenus avec l'url /menus");
    model.addAttribute("menu", new Menu());
    logger.debug("on ajoute un nouveau Bean Menu aux attribus");
    model.addAttribute("listMenus", this.menuService.listMenus());
    logger.debug("on ajoute une liste de Bean Menu aux attribus");
    model.addAttribute("listBurgers", this.menuService.listBurgers());
    model.addAttribute("listeDesNomsDeBurger", listeDesNomsDeBurger);
    model.addAttribute("listeDesBoissons", listeDesBoissons);
    return "menu";
  }
  
  //For add and update Menu both
  @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
  public String addMenu(@ModelAttribute("menu") Menu m) {
    
    if (m.getId() == 0) {
      //new menu, add it
      this.menuService.addMenu(m);
    }
    else {
      //existing menu, call update
      this.menuService.updateMenu(m);
    }
    
    return "redirect:/menus";
  }
  
  @RequestMapping("/remove/{id}")
  public String removeMenu(@PathVariable("id") int id) {
    
    this.menuService.removeMenu(id);
    return "redirect:/menus";
  }
  
  @RequestMapping("/edit/{id}")
  public String editMenu(@PathVariable("id") int id, Model model) {
    model.addAttribute("listeDesNomsDeBurger", listeDesNomsDeBurger);
    model.addAttribute("listeDesBoissons", listeDesBoissons);
    model.addAttribute("menu", this.menuService.getMenuById(id));
    model.addAttribute("listMenus", this.menuService.listMenus());
    return "menu";
  }
  
}
