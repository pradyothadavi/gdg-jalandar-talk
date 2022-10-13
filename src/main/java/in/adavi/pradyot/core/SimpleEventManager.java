package in.adavi.pradyot.core;

import com.google.inject.Inject;
import in.adavi.pradyot.api.Event;
import in.adavi.pradyot.app.AppContext;
import in.adavi.pradyot.db.EventDao;
import in.adavi.pradyot.idgenerator.UniqueIdGenerator;
import in.adavi.pradyot.idgenerator.UniqueIdGenerators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleEventManager implements EventManager {
  
  private static final Logger log = LoggerFactory.getLogger(SimpleEventManager.class);
  private EventDao eventDao;
  
  @Inject
  public SimpleEventManager(EventDao eventDao) {
    this.eventDao = eventDao;
  }
  
  /**
   * @param event event details
   * @return eventId
   */
  @Override
  public String add(Event event) {
    
    Boolean isTestRequest = AppContext.isTestRequest();
    log.info("isTestRequest: {}",isTestRequest);
    String eventId = UniqueIdGenerators.ALPHANUMERIC_WITH_TIME.generate("EVT",30);
    if(isTestRequest) {
      eventId = UniqueIdGenerators.ALPHANUMERIC_WITH_DATE.generate("TESTEVT",30);
    }
    event.setId(eventId);
    eventDao.add(event);
    return eventId;
  }
  
  /**
   * @param eventName name of the event
   * @return event details
   */
  @Override
  public Event getByName(String eventName) {
    return eventDao.getByName(eventName);
  }
  
  /**
   * @param eventId identifier of the event
   * @return event
   */
  @Override
  public Event getById(String eventId) {
    return null;
  }
}
