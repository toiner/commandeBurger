/**
 * Paquet de définition
 */
package com.dodo.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Description :
* Bean servant à gérer les données relatives au menu.
* Entity bean with JPA annotations
 * Hibernate provides JPA implementation
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
@Table(name = "MENU")
public class Menu {
  
  private static final Logger logger = LoggerFactory.getLogger(Menu.class);
  @Id
  @Column(name = "menu_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @JoinColumn(name = "burger_id")
  @ManyToOne
  private Burger burger;
  private String burgerName;
  private String boisson;
  private String nom;
  private Date dateDeCommande;
  
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
  public String getBoisson() {
    return boisson;
  }
  
  /**
   * @param boisson valeur à positionner au sein de la propriété
   */
  public void setBoisson(String boisson) {
    logger.debug("setBoisson() <-- " + boisson);
    this.boisson = boisson;
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
  public Burger getBurger() {
    return burger;
  }
  
  /**
   * @param burger valeur à positionner au sein de la propriété
   */
  public void setBurger(Burger burger) {
    this.burger = burger;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getBurgerName() {
    return burgerName;
  }
  
  /**
   * @param burgerName valeur à positionner au sein de la propriété
   */
  public void setBurgerName(String burgerName) {
    logger.debug("setBurgerName() <-- " + burgerName);
    this.burgerName = burgerName;
  }
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public Date getDateDeCommande() {
    return dateDeCommande;
  }
  
  /**
   * @param dateDeCommande valeur à positionner au sein de la propriété
   */
  public void setDateDeCommande(Date dateDeCommande) {
    logger.debug("setDateDeCommande() <-- " + dateDeCommande);
    this.dateDeCommande = dateDeCommande;
  }
  
  @Override
  public String toString() {
    return "Menu, id=" + id + ", nom=" + nom + ", burger=" + burger + ", boisson=" + boisson;
  }
  
}
