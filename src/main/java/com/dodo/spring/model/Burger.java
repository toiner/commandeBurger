/**
 * Paquet de définition
 */
package com.dodo.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Description :
* On s'en fou !!!.
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
public class Burger {
  /** Version extraite du gestionnaire de configuration */
  public static final String CLASS_VERSION = "$Revision:   1.0  $";
  private static final Logger logger = LoggerFactory.getLogger(Burger.class);
  @Id
  @Column(name = "burger_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nom;
  private String description;
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public int getId() {
    return id;
  }
  
  /**
   * @param id valeur à positionner au sein de la propriété
   */
  public void setId(int id) {
    logger.debug("setId() <-- " + id);
    this.id = id;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getNom() {
    return nom;
  }
  
  /**
   * @param nom valeur à positionner au sein de la propriété
   */
  public void setNom(String nom) {
    logger.debug("setNom() <-- " + nom);
    this.nom = nom;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * @param description valeur à positionner au sein de la propriété
   */
  public void setDescription(String description) {
    logger.debug("setDescription() <-- " + description);
    this.description = description;
  }
  
}
