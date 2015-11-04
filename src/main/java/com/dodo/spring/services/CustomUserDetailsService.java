package com.dodo.spring.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dodo.spring.model.User;

/**
* Description :
* Service permettant de gérer les droits utilisateurs et charger un utilisateur par son ssoID.
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
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  private UserService userService;
  
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
    User user = userService.findBySso(ssoId);
    System.out.println("User : " + user);
    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("Username not found");
    }
    return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                                                                  user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
  }
  
  /**
   * Méthode permettant d'accorder des droits/privilèges aux utilisateurs.
   * @param user L'utilisateur
   * @return la liste des privilièges
   */
  private List<GrantedAuthority> getGrantedAuthorities(User user) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getType()));
    /*for (UserProfile userProfile : user.getUserProfiles()) {
      System.out.println("UserProfile : " + userProfile);
      authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
    }*/
    System.out.print("authorities :" + authorities);
    return authorities;
  }
  
}
