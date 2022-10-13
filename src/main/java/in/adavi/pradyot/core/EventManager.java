package in.adavi.pradyot.core;

import in.adavi.pradyot.api.Event;

public interface EventManager {
  
  String add(Event event);
  
  Event getByName(String eventName);
  
  Event getById(String eventId);
}
