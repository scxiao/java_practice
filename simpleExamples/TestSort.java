import java.util.*;

// class SeqInfo implements Comparator<SeqInfo>, Comparable<SeqInfo> {
class SeqInfo implements Comparable<SeqInfo> {
  int seqSize;
  int loc;

  public SeqInfo(int size, int l) {
    seqSize = size;
    loc = l;
  }

//  public int compare(SeqInfo s1, SeqInfo s2) {
//    return s1.seqSize - s2.seqSize;
//  }

  public int compareTo(SeqInfo e) {
    return this.seqSize - e.seqSize;
  }
}

public class TestSort {
  public static void main(String[] args) {
    Vector<SeqInfo> list = new Vector<SeqInfo>();
    list.add(new SeqInfo(1, 3));
    list.add(new SeqInfo(2, 3));
    list.add(new SeqInfo(8, 3));
    list.add(new SeqInfo(3, 3));
    list.add(new SeqInfo(6, 3));
    list.add(new SeqInfo(4, 3));

    Collections.sort(list);

    for (SeqInfo s : list) {
      System.out.println("size = " + s.seqSize + ", loc = " + s.loc);
    }

    return;
  }
}

