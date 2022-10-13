package in.adavi.pradyot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pradyothadavi.core.RateLimitBundleConfiguration;
import io.dropwizard.Configuration;

public class GdgJalandarTalkConfiguration extends Configuration {
    // TODO: implement service configuration
  
  private RateLimitBundleConfiguration rateLimitBundleConfiguration;
  
  @JsonProperty("rateLimiter")
  public RateLimitBundleConfiguration getRateLimitBundleConfiguration() {
    return rateLimitBundleConfiguration;
  }
  
  public void setRateLimitBundleConfiguration(RateLimitBundleConfiguration rateLimitBundleConfiguration) {
    this.rateLimitBundleConfiguration = rateLimitBundleConfiguration;
  }
}
