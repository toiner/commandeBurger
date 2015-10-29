/**
 * Paquet de définition
 */
package com.dodo.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dodo.spring.dao.UserDao;
import com.dodo.spring.model.UserRole;

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
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
  
  //get user from the database, via Hibernate
  @Autowired
  private UserDao userDao;
  
  //to declare a transactional method.
  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    
    com.dodo.spring.model.User user = userDao.findByUserName(username);
    List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
    
    return buildUserForAuthentication(user, authorities);
    
  }
  
  // Converts com.dodo.spring.model.User user to
  // org.springframework.security.core.userdetails.User
  private User buildUserForAuthentication(com.dodo.spring.model.User user, List<GrantedAuthority> authorities) {
    return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
  }
  
  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
    
    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
    
    // Build user's authorities
    for (UserRole userRole : userRoles) {
      setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }
    
    List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
    
    return Result;
  }
  
  public UserDao getUserDao() {
    return userDao;
  }
  
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
  
}
