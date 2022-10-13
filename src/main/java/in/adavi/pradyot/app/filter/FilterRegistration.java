package in.adavi.pradyot.app.filter;

import in.adavi.pradyot.app.filter.request.ContextFilter;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;

@Provider
public class FilterRegistration implements DynamicFeature {
  /**
   * A callback method called by the runtime during the application
   * deployment to register provider instances or classes in a
   * {@link Configuration runtime configuration} scope of a particular {@link HttpMethod
   * resource or sub-resource method}; i.e. the providers that should be dynamically bound
   * to the method.
   * <p>
   * The registered provider instances or classes are expected to be implementing one
   * or more of the following interfaces:
   * </p>
   * <ul>
   * <li>ContainerRequestFilter</li>
   * <li>ContainerResponseFilter}</li>
   * <li>ReaderInterceptor}</li>
   * <li>WriterInterceptor}</li>
   * <li>{@link Feature}</li>
   * </ul>
   * <p>
   * A provider instance or class that does not implement any of the interfaces
   * above may be ignored by the API implementation. In such case a
   * {@link Level#WARNING warning} message must be logged.
   * API implementations may support additional provider contracts that
   * can be registered using a dynamic feature concept.
   * </p>
   * <p>
   * Conceptually, this callback method is called during a {@link HttpMethod
   * resource or sub-resource method} discovery phase (typically once per each discovered
   * resource or sub-resource method) to register provider instances or classes in a
   * {@code configuration} scope of each particular method identified by the supplied
   * {@link ResourceInfo resource information}.
   * The responsibility of the feature is to properly update the supplied {@code configuration}
   * context.
   * </p>
   *  @param resourceInfo resource class and method information.
   *
   * @param context configurable resource or sub-resource method-level runtime context
   *                associated with the {@code resourceInfo} in which the feature
   */
  @Override
  public void configure(ResourceInfo resourceInfo, FeatureContext context) {
    context.register(ContextFilter.class);
  }
}
