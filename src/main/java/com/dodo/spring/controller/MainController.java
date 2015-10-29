/**
 * Paquet de définition
 */
package com.dodo.spring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
* Description :
* Donnez une description textuelle du service fourni par cette classe.
*
* <TABLE>
*   <TR>
*     <TD><B>Attributs SVN :</B></TD>
*     <TD>&nbsp;</TD>
*   </TR>
*   <TR>
*     <TD><I>Nom du fichier :</I></TD>
*     <TD>$HeadURL:   O:/Kernel5 Livraison/archives/kernel/tools/eclipse/config/ArchitectureImmobilierCodeTemplates.xml-arc  $</TD>
*   </TR>
*   <TR>
*     <TD><I>Modifié le :</I></TD>
*     <TD>$Date:   Apr 16 2009 11:52:40  $</TD>
*   </TR>
* </TABLE>
*
* @version : $Revision:   1.0  $
* @author  : SOPRA Group - $Author:   tintin  $
*
*/
@Controller
public class MainController {
  
  @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
  public ModelAndView defaultPage() {
    
    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security + Hibernate Example");
    model.addObject("message", "This is default page!");
    model.setViewName("hello");
    return model;
    
  }
  
  @RequestMapping(value = "/admin**", method = RequestMethod.GET)
  public ModelAndView adminPage() {
    
    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security + Hibernate Example");
    model.addObject("message", "This page is for ROLE_ADMIN only!");
    model.setViewName("admin");
    
    return model;
    
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
    
    ModelAndView model = new ModelAndView();
    if (error != null) {
      model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
    }
    
    if (logout != null) {
      model.addObject("msg", "You've been logged out successfully.");
    }
    model.setViewName("login");
    
    return model;
    
  }
  
  // customize the error message
  private String getErrorMessage(HttpServletRequest request, String key) {
    
    Exception exception = (Exception) request.getSession().getAttribute(key);
    
    String error = "";
    if (exception instanceof BadCredentialsException) {
      error = "Invalid username and password!";
    }
    else if (exception instanceof LockedException) {
      error = exception.getMessage();
    }
    else {
      error = "Invalid username and password!";
    }
    
    return error;
  }
  
  // for 403 access denied page
  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public ModelAndView accesssDenied() {
    
    ModelAndView model = new ModelAndView();
    
    // check if user is login
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!(auth instanceof AnonymousAuthenticationToken)) {
      UserDetails userDetail = (UserDetails) auth.getPrincipal();
      System.out.println(userDetail);
      
      model.addObject("username", userDetail.getUsername());
      
    }
    
    model.setViewName("403");
    return model;
    
  }
  
}
