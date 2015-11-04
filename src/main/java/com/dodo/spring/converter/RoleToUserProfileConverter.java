/**
 * Paquet de définition
 */
package com.dodo.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.dodo.spring.model.UserProfile;
import com.dodo.spring.services.UserProfileService;

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
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {
  
  @Autowired
  UserProfileService userProfileService;
  
  /*
   * Gets UserProfile by Id
   * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
   */
  @Override
  public UserProfile convert(Object element) {
    Integer id = Integer.parseInt((String) element);
    UserProfile profile = userProfileService.findById(id);
    System.out.println("Profile : " + profile);
    return profile;
  }
  
  /*
   * Gets UserProfile by type
   * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
   */
  /*
  public UserProfile convert(Object element) {
    String type = (String)element;
    UserProfile profile= userProfileService.findByType(type);
    System.out.println("Profile ... : "+profile);
    return profile;
  }
  */
  
}
