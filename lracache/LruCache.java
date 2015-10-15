package impl;
import java.util.*;

class Node {
  int nKey;
  Node next, prev;
  Node (int key) {
    nKey = key;
    next = null;
  }
}

class NodeList {
  Node head, tail;
  HashMap<Integer, Node> hMap;

  public NodeList() {
    head = tail = null;
    hMap = new HashMap<Integer, Node>();
  }

  public void AddKey(int key) {
    Node n = new Node(key);
    hMap.put(key, n);
    AddNode(n);
  }

  public int GetLraKey() {
    if (head == null) {
      return -1;
    }

    int key = head.nKey;
    // only one node in the list
    if (head == tail) {
      head = tail = null;
    }
    else {
      head = head.prev;
      head.next = null;
    }

    return key;
  }

  public Boolean MoveToTail(int key) {
    Node n = hMap.get(key);
    if (n == null) {
      return Boolean.FALSE;
    }

    if (n == tail) {
      return Boolean.TRUE;
    }
    else if (n == head) {
      // remove from head
      head = head.prev;
      head.next = null;

      // add at the tail
      n.next = tail;
      tail.prev = n;
      tail = n;
    }
    else {
      n.next.prev = n.prev;
      n.prev.next = n.next;

      n.next = tail;
      tail.prev = n;
      tail = n;
    }

    return Boolean.TRUE;
  }

  private void AddNode(Node n) {
    if (tail == null) {
      head = tail = n;
      return;
    }
    else {
      n.next = tail;
      tail.prev = n;
      tail = n;
    }
  }
};

public class LruCache {
  HashMap<Integer, Integer> LocMap;
  int [] Value;
  NodeList nl;
  int m_nCapNum;
  int m_nCapNo;

  public LruCache(int capacity) {
    m_nCapNum = capacity;
    m_nCapNo = 0;
    LocMap = new HashMap<Integer, Integer>();
    nl = new NodeList();
    Value = new int[m_nCapNum];
  }

  // If not full, insert directly; otherwise, replace the least
  // recent accessed one and move that location to the most
  // recent accessed one
  public void insert(int key, int value) {
    Integer LocObj = LocMap.get(key);
    if (LocObj == null) { // key not exist
      if (m_nCapNo < m_nCapNum) { // cache not full
        Value[m_nCapNo] = value;
        LocMap.put(key, m_nCapNo);
        nl.AddKey(key);
        m_nCapNo++;
      }
      else { // full, get the least recent accessed one
        int nLraKey =  nl.GetLraKey();
        Integer LocObj1 = LocMap.get(nLraKey);
        LocMap.remove(nLraKey);
        int loc1 = LocObj1.intValue();
        Value[loc1] = value;
        LocMap.put(key, loc1);
        nl.AddKey(key);
      }
    }
    else {  // key exists
      int loc = LocObj.intValue();
      Value[loc] = value;
      nl.MoveToTail(key);
    }
  }

  public int get(int key) {
    Integer LocObj = LocMap.get(key);
    if (LocObj == null) {
      return -100;
    }

    int loc = LocObj.intValue();
    int retValue = Value[loc];
    nl.MoveToTail(key);

    return retValue;
  }
}

