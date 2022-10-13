package in.adavi.pradyot;

import com.github.pradyothadavi.RateLimitBundle;
import com.github.pradyothadavi.core.RateLimitBundleConfiguration;
import com.google.inject.Guice;
import com.google.inject.Injector;
import in.adavi.pradyot.app.GdgJalandarTalkModule;
import in.adavi.pradyot.app.auth.AppUser;
import in.adavi.pradyot.app.auth.BasicAuthenticator;
import in.adavi.pradyot.app.auth.BasicAuthorizer;
import in.adavi.pradyot.app.filter.FilterRegistration;
import in.adavi.pradyot.resources.EventResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class GdgJalandarTalkApplication extends Application<GdgJalandarTalkConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GdgJalandarTalkApplication().run(args);
    }

    @Override
    public String getName() {
        return "GDG Jalandar Talk";
    }

    @Override
    public void initialize(final Bootstrap<GdgJalandarTalkConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new RateLimitBundle<GdgJalandarTalkConfiguration>() {
            @Override
            protected RateLimitBundleConfiguration getRateLimitBundleConfiguration(GdgJalandarTalkConfiguration configuration) {
                return configuration.getRateLimitBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final GdgJalandarTalkConfiguration configuration,
                    final Environment environment) {
        Injector injector = Guice.createInjector(new GdgJalandarTalkModule(environment,configuration));
        
        environment.jersey().register(injector.getInstance(EventResource.class));
    
        environment.jersey().register(FilterRegistration.class);
    
        environment.jersey().register(new AuthDynamicFeature(
          new BasicCredentialAuthFilter.Builder<AppUser>()
            .setAuthenticator(new BasicAuthenticator())
            .setAuthorizer(new BasicAuthorizer())
            .setRealm("SUPER SECRET STUFF")
            .buildAuthFilter()));
    
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AppUser.class));
    }

}
