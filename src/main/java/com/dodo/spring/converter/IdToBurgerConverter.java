/**
 * Paquet de définition
 */
package com.dodo.spring.converter;

import org.springframework.core.convert.converter.Converter;
import com.dodo.spring.dao.MenuDAO;
import com.dodo.spring.model.Burger;

/**
* Description :
* Rien à branler !!!.
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
public class IdToBurgerConverter implements Converter<Integer, Burger> {
  
  MenuDAO dao;
  
  @Override
  public Burger convert(Integer id) {
    return dao.getBurgerById(id);
  }
}
