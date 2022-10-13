package in.adavi.pradyot.db;

import in.adavi.pradyot.api.Event;

public interface EventDao {
  
  /**
   * Add the event to the datastore
   * @param event event details
   */
  void add(Event event);
  
  /**
   * Get the event by name
   * @param eventName name of the event
   * @return event details
   */
  Event getByName(String eventName);
  
  /**
   * Get the event by id
   * @param eventId identifier of the event
   * @return event details
   */
  Event getById(String eventId);
}
