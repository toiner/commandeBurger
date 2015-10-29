/**
 * Paquet de définition
 */
package com.dodo.spring.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Entity
@Table(name = "users", catalog = "test")
public class User {
  /** Version extraite du gestionnaire de configuration */
  public static final String CLASS_VERSION = "$Revision:   1.0  $";
  
  private static final Logger logger = LoggerFactory.getLogger(User.class);
  
  @Id
  @Column(name = "username", unique = true, nullable = false, length = 45)
  private String username;
  @Column(name = "password", nullable = false, length = 60)
  private String password;
  @Column(name = "enabled", nullable = false)
  private boolean enabled;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<UserRole> userRole = new HashSet<UserRole>(0);
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getUsername() {
    return username;
  }
  
  /**
   * @param username valeur à positionner au sein de la propriété
   */
  public void setUsername(String username) {
    logger.debug("setUsername() <-- " + username);
    this.username = username;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * @param password valeur à positionner au sein de la propriété
   */
  public void setPassword(String password) {
    logger.debug("setPassword() <-- " + password);
    this.password = password;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public boolean isEnabled() {
    return enabled;
  }
  
  /**
   * @param enabled valeur à positionner au sein de la propriété
   */
  public void setEnabled(boolean enabled) {
    logger.debug("setEnabled() <-- " + enabled);
    this.enabled = enabled;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public Set<UserRole> getUserRole() {
    return userRole;
  }
  
  /**
   * @param userRole valeur à positionner au sein de la propriété
   */
  public void setUserRole(Set<UserRole> userRole) {
    logger.debug("setUserRole() <-- " + userRole);
    this.userRole = userRole;
  }
  
}
