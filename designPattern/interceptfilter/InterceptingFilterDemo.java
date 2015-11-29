import impl.FilterManager;
import impl.AuthenticationFilter;
import impl.DebugFilter;
import impl.Client;
import impl.Target;

public class InterceptingFilterDemo {
  public static void main(String[] args) {
    FilterManager filterManager = new FilterManager(new Target());
    filterManager.setFilter(new AuthenticationFilter());
    filterManager.setFilter(new DebugFilter());

    Client client = new Client();
    client.setFilterManager(filterManager);
    client.sendRequest("HOME");
  }
}

