import impl.LruCache;

public class TestLra {
  public static void main(String[] args) {
    LruCache cache = new LruCache(3);
    cache.insert(2, 3);
    int value = cache.get(2);
    System.out.println("value = " + value);

    value = cache.get(3);
    System.out.println("value = " + value);

    cache.insert(3, 4);
    value = cache.get(3);
    System.out.println("value = " + value);
    cache.insert(4, 5);
    cache.insert(5, 6);
    value = cache.get(2);
    System.out.println("value = " + value);
    return;
  }
}

