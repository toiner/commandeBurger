/**
 * Paquet de définition
 */
package com.dodo.spring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
public class QuickPasswordEncodingGenerator {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    String password = "abc125";
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    System.out.println(passwordEncoder.encode(password));
  }
  
}
