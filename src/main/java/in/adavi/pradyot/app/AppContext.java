package in.adavi.pradyot.app;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class AppContext {
  
  private static final ThreadLocal<MultivaluedMap<String, String>>
    threadLocalHeaders = new ThreadLocal<>();
  
  public static void reset() {
    threadLocalHeaders.remove();
  }
  
  public static MultivaluedMap<String, String> getHeaders() {
    return threadLocalHeaders.get();
  }
  
  public static void setHeaders(MultivaluedMap<String, String> headers) {
    threadLocalHeaders.set(headers);
  }
  
  public static List<String> getHeaderValues(String key) {
    MultivaluedMap<String, String> headers = threadLocalHeaders.get();
    List<String> values = null;
    if (null != headers) {
      values = headers.get(key);
    }
    return values;
  }
  
  public static Boolean isTestRequest() {
    List<String> testReqHeaderValues = getHeaderValues(Constants.X_TEST_REQUEST);
    if (null != testReqHeaderValues && !testReqHeaderValues.isEmpty()) {
      return Constants.TRUE.equalsIgnoreCase(testReqHeaderValues.get(0));
    }
    return Boolean.FALSE;
  }
}
