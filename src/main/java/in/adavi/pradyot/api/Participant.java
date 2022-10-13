package in.adavi.pradyot.api;

public class Participant {
  
  private Name name;
  
  private Boolean shortListed;
  
  public Name getName() {
    return name;
  }
  
  public void setName(Name name) {
    this.name = name;
  }
  
  public Boolean getShortListed() {
    return shortListed;
  }
  
  public void setShortListed(Boolean shortListed) {
    this.shortListed = shortListed;
  }
}
