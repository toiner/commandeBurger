package com.dodo.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
  
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @NotEmpty
  @Size(min=2, max=30)
  @Column(name = "SSO_ID", unique = true, nullable = false, length = 30)
  private String ssoId;
  
  @NotEmpty
  @Size(min=2, max=30)
  @Column(name = "PASSWORD", nullable = false, length = 100)
  private String password;
  
  @NotEmpty
  @Size(min=2, max=30)
  @Pattern(regexp = "[A-Za-z-]*")
  @Column(name = "FIRST_NAME", nullable = false, length = 30)
  private String firstName;
  
  @NotEmpty
  @Size(min=2, max=30)
  @Pattern(regexp = "[A-Za-z-]*")
  @Column(name = "LAST_NAME", nullable = false, length = 30)
  private String lastName;
  
  @NotEmpty
  @Size(min=2, max=30)
  @Email
  @Pattern(regexp = "[0-9A-Za-z.-]*@soprasteria.com", message="veuillez utilisez une adresse mail soprasteria")
  @Column(name = "EMAIL", nullable = false, length = 30)
  private String email;
  
  @NotEmpty
  @Column(name = "STATE", nullable = false, length = 30)
  private String state = State.ACTIVE.getState();
  
  @Column(name = "TYPE", length = 30, nullable = false)
  private String type = UserProfileType.USER.getUserProfileType();
  
  /*@ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "USER_TO_USER_PROFILE",
    joinColumns = { @JoinColumn(name = "USER_ID", nullable = false) },
    inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID", nullable = false, updatable = false) })
  private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);*/
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getSsoId() {
    return ssoId;
  }
  
  public void setSsoId(String ssoId) {
    this.ssoId = ssoId;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  /* public Set<UserProfile> getUserProfiles() {
     return userProfiles;
   }
   
   public void setUserProfiles(Set<UserProfile> userProfiles) {
     this.userProfiles = userProfiles;
   }*/
  
  /**
   * @return la valeur positionnée au sein de la propriété
   */
  public String getType() {
    return type;
  }
  
  /**
   * @param type valeur à positionner au sein de la propriété
   */
  public void setType(String type) {
    this.type = type;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + id;
    result = (prime * result) + ((ssoId == null) ? 0 : ssoId.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof User)) {
      return false;
    }
    User other = (User) obj;
    if (id != other.id) {
      return false;
    }
    if (ssoId == null) {
      if (other.ssoId != null) {
        return false;
      }
    }
    else if (!ssoId.equals(other.ssoId)) {
      return false;
    }
    return true;
  }
  
  @Override
  public String toString() {
    return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
           + ", firstName=" + firstName + ", lastName=" + lastName
           + ", email=" + email + ", state=" + state + ", userProfile=" + type + "]";
  }
  
}
