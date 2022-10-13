package in.adavi.pradyot.app;

import com.google.inject.AbstractModule;
import in.adavi.pradyot.GdgJalandarTalkConfiguration;
import in.adavi.pradyot.core.EventManager;
import in.adavi.pradyot.core.SimpleEventManager;
import in.adavi.pradyot.db.EventDao;
import in.adavi.pradyot.db.InMemoryEventDao;
import io.dropwizard.setup.Environment;

public class GdgJalandarTalkModule extends AbstractModule {
  
  private final Environment environment;
  
  private final GdgJalandarTalkConfiguration gdgJalandarTalkConfiguration;
  
  public GdgJalandarTalkModule(Environment environment, GdgJalandarTalkConfiguration gdgJalandarTalkConfiguration) {
    this.environment = environment;
    this.gdgJalandarTalkConfiguration = gdgJalandarTalkConfiguration;
  }
  
  @Override
  protected void configure() {
    bind(EventManager.class).to(SimpleEventManager.class);
    
    bind(EventDao.class).to(InMemoryEventDao.class);
  }
}
