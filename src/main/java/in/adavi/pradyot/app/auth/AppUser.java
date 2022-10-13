package in.adavi.pradyot.app.auth;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Set;

public class AppUser implements Principal {
  
  private final String name;
  
  private final Set<String> roles;
  
  public AppUser(String name, Set<String> roles) {
    this.name = name;
    this.roles = roles;
  }
  
  public Set<String> getRoles() {
    return roles;
  }
  
  /**
   * Returns the name of this principal.
   *
   * @return the name of this principal.
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  /**
   * Returns true if the specified subject is implied by this principal.
   *
   * <p>The default implementation of this method returns true if
   * {@code subject} is non-null and contains at least one principal that
   * is equal to this principal.
   *
   * <p>Subclasses may override this with a different implementation, if
   * necessary.
   *
   * @param subject the {@code Subject}
   * @return true if {@code subject} is non-null and is
   * implied by this principal, or false otherwise.
   * @since 1.8
   */
  @Override
  public boolean implies(Subject subject) {
    return Principal.super.implies(subject);
  }
  
  @Override
  public String toString() {
    return "AppUser{" +
      "name='" + name + '\'' +
      ", roles=" + roles +
      '}';
  }
}
