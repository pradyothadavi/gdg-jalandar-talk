package in.adavi.pradyot.app.auth;

import io.dropwizard.auth.AuthorizationContext;
import io.dropwizard.auth.Authorizer;

import javax.annotation.Nullable;
import javax.ws.rs.container.ContainerRequestContext;

public class BasicAuthorizer implements Authorizer<AppUser> {
  /**
   * @param appUser
   * @param role
   * @deprecated
   */
  @Override
  public boolean authorize(AppUser appUser, String role) {
    return appUser.getRoles() != null && appUser.getRoles().contains(role);
  }
  
  /**
   * @param principal
   * @param role
   * @param requestContext
   * @return
   */
  @Override
  public boolean authorize(AppUser principal, String role, @Nullable ContainerRequestContext requestContext) {
    return Authorizer.super.authorize(principal, role, requestContext);
  }
  
  /**
   * @param principal
   * @param role
   * @param requestContext
   * @return
   */
  @Override
  public AuthorizationContext<AppUser> getAuthorizationContext(AppUser principal, String role, @Nullable ContainerRequestContext requestContext) {
    return Authorizer.super.getAuthorizationContext(principal, role, requestContext);
  }
}
