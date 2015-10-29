/**
 * Paquet de définition
 */
package com.dodo.spring.model;

import static javax.persistence.GenerationType.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "user_roles", catalog = "test", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "username" }))
public class UserRole {
  /** Version extraite du gestionnaire de configuration */
  public static final String CLASS_VERSION = "$Revision:   1.0  $";
  
  private static final Logger logger = LoggerFactory.getLogger(UserRole.class);
  
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "user_role_id", unique = true, nullable = false)
  private Integer userRoleId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "username", nullable = false)
  private User user;
  @Column(name = "role", nullable = false, length = 45)
  private String role;
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public Integer getUserRoleId() {
    return userRoleId;
  }
  
  /**
   * @param userRoleId valeur à positionner au sein de la propriété
   */
  public void setUserRoleId(Integer userRoleId) {
    logger.debug("setUserRoleId() <-- " + userRoleId);
    this.userRoleId = userRoleId;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public User getUser() {
    return user;
  }
  
  /**
   * @param user valeur à positionner au sein de la propriété
   */
  public void setUser(User user) {
    logger.debug("setUser() <-- " + user);
    this.user = user;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getRole() {
    return role;
  }
  
  /**
   * @param role valeur à positionner au sein de la propriété
   */
  public void setRole(String role) {
    logger.debug("setRole() <-- " + role);
    this.role = role;
  }
}
