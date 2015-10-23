import impl.MyHashTable;

public class TestMyHashTable {
  public static void main(String[] args) {
    MyHashTable mht = new MyHashTable();
    mht.put("abc", 1);
    mht.put("ced", 2);

    System.out.println("abc = " + mht.get("abc"));
    System.out.println("ced = " + mht.get("ced"));
  }
}

