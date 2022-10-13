package in.adavi.pradyot.db;

import in.adavi.pradyot.api.Event;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEventDao implements EventDao {
  
  private List<Event> events;
  
  public InMemoryEventDao() {
    this.events = new ArrayList<>();
  }
  
  /**
   * Add the event to the datastore
   *
   * @param event event details
   */
  @Override
  public void add(Event event) {
    this.events.add(event);
  }
  
  /**
   * Get the event by name
   *
   * @param eventName name of the event
   * @return event details
   */
  @Override
  public Event getByName(String eventName) {
    for (Event event:
         this.events) {
      if(event.getName().equalsIgnoreCase(eventName)){
        return event;
      }
    }
    return null;
  }
  
  /**
   * Get the event by id
   *
   * @param eventId identifier of the event
   * @return event details
   */
  @Override
  public Event getById(String eventId) {
    return null;
  }
}
