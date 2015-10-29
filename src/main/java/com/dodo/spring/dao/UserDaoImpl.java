/**
 * Paquet de définition
 */
package com.dodo.spring.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dodo.spring.model.User;

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
@Repository
public class UserDaoImpl implements UserDao {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public User findByUserName(String username) {
    
    List<User> users = new ArrayList<User>();
    
    users = sessionFactory.getCurrentSession()
                          .createQuery("from User where username=?")
                          .setParameter(0, username)
                          .list();
    
    if (users.size() > 0) {
      return users.get(0);
    }
    else {
      return null;
    }
    
  }
  
  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }
  
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  
}
