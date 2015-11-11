package com.dodo.spring.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dodo.spring.model.Menu;
import com.dodo.spring.model.User;
import com.dodo.spring.model.UserProfile;
import com.dodo.spring.services.MenuService;
import com.dodo.spring.services.UserProfileService;
import com.dodo.spring.services.UserService;

@Controller
public class HelloWorldController {
  
	  private static final String[] tableauDeBurger = { "Véritable", "Véritable Hallal", "Mont d'or", "Savoyard", "Jurassien's", "Burger du moment",
	                                                   "Spécial Hongrois" };
	  private static final List<String> listeDesNomsDeBurger = Arrays.asList(tableauDeBurger);
	  private static final String[] tableauDeBoisson = { "Coca", "Orangina", "Ice tea", "7up", "Tropico", "Coca zero", "Dr pepper", "Eau (pour les faibles)", "Autre" };
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
	    model.addAttribute("user", getPrincipal());
	    return "menu";
	  }
	  
	  //For add and update Menu both
	  @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
	public String addMenu(@ModelAttribute("menu") Menu m, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			logger.error("Il y a des erreurs dans la validation du formulaire");
		} else {
			if (m.getId() == 0) {
				// new menu, add it
				m.setNom(getPrincipal());
				this.menuService.addMenu(m);
			} else {
				// existing menu, call update
				m.setNom(getPrincipal());
				this.menuService.updateMenu(m);
			}
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
	  
	  
	  /************************************************************/
  private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
  @Autowired
  UserProfileService userProfileService;
  
  @Autowired
  UserService userService;
  
  @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
  public String homePage(ModelMap model) {
    logger.debug("entrée dans homePage avec l'url /home ou / ");
    model.addAttribute("greeting", "Enchanté, Bienvenue sur le site de commande des burgers");
    logger.debug("ajout de la valeur ''Enchanté, Bienvenue sur le site de commande des burgers'' à la variable du model ''greeting''");
    return "welcome";
  }
  
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String adminPage(ModelMap model) {
    logger.debug("entrée dans adminPage avec l'url /admin");
    model.addAttribute("user", getPrincipal());
    return "admin";
  }
  
  @RequestMapping(value = "/db", method = RequestMethod.GET)
  public String dbaPage(ModelMap model) {
    logger.debug("entrée dans dbaPage avec l'url /db");
    model.addAttribute("user", getPrincipal());
    return "dba";
  }
  
  @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
  public String accessDeniedPage(ModelMap model) {
    logger.debug("entrée dans accessDeniedPage avec l'url /Access_Denied");
    model.addAttribute("user", getPrincipal());
    return "accessDenied";
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    logger.debug("entrée dans loginPage avec l'url /login");
    return "login";
  }
  
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    logger.debug("entrée dans logoutPage avec l'url /logout");
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";
  }
  
  @RequestMapping(value = "/newUser", method = RequestMethod.GET)
  public String newRegistration(ModelMap model) {
    logger.debug("entrée dans newRegistration avec l'url /newUser");
    User user = new User();
    model.addAttribute("user", user);
    return "newuser";
  }
  
  /*
   * This method will be called on form submission, handling POST request It
   * also validates the user input
   */
  @RequestMapping(value = "/newUser", method = RequestMethod.POST)
  public String saveRegistration(@Valid User user,
                                 BindingResult result, ModelMap model) {
    
    if (result.hasErrors()) {
      System.out.println("There are errors");
      return "newuser";
    }
    userService.save(user);
    
    System.out.println("First Name : " + user.getFirstName());
    System.out.println("Last Name : " + user.getLastName());
    System.out.println("SSO ID : " + user.getSsoId());
    System.out.println("Password : " + user.getPassword());
    System.out.println("Email : " + user.getEmail());
    System.out.println("Profile utilisateur : " + user.getType());
    /*if (user.getUserProfiles() != null) {
      for (UserProfile profile : user.getUserProfiles()) {
        System.out.println("Profile : " + profile.getType());
      }
    }*/
    
    model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
    return "registrationsuccess";
  }
  
  private String getPrincipal() {
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    if (principal instanceof UserDetails) {
      userName = ((UserDetails) principal).getUsername();
    }
    else {
      userName = principal.toString();
    }
    return userName;
  }
  
  @ModelAttribute("roles")
  public List<UserProfile> initializeProfiles() {
    return userProfileService.findAll();
  }
  
}
