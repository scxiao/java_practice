package impl;

import java.util.*;

class Item<K, V> {
  K key;
  V value;

  public Item(K k, V v) {
    key = k;
    value = v;
  }

  public Item() {
    key = null;
    value = null;
  }

  public void clear() {
    key = null;
    value = null;
  }
}

public class MyHashTable {
  private int itemNum;
  private int itemNo;
  private String[] keys;
  private Integer[] values;

  private int hashCode1(Object key) {
    int index = key.hashCode() % itemNum;
    if (index < 0) {
      index += itemNum;
    }

    return index;
  }

  public MyHashTable() {
    itemNum = 100;
    itemNo = 0;
    keys = new String[itemNum];
    values = new Integer[itemNum];
  }

  public MyHashTable(int size) {
    itemNum = size;
    itemNo = 0;
    keys = new String[itemNum];
    values = new Integer[itemNum];
  }

  public void clear() {
    itemNo = 0;
    for (int i = 0; i < itemNum; i++) {
      keys[i] = null;
      values[i] = null;
    }
    return;
  }

  public boolean contains(Object value) {
    int i;
    for (i = 0; i < itemNum; i++) {
      if (values[i] == value) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  public boolean containsKey(Object key) {
    int index = hashCode1(key);
    if (keys[index] == null) {
      return Boolean.FALSE;
    }

    return Boolean.TRUE;
  }

  public boolean isEmpty() {
    if (itemNo == 0) {
      return Boolean.TRUE;
    }
    else {
      return Boolean.FALSE;
    }
  }

  public Object put(Object key, Object value) {
    int index = hashCode1(key);
    itemNo++;
    if (keys[index] == null) {
      keys[index] = (String)key;
      values[index] = (Integer)value;
      return null;
    }
    else {
      Integer iobj = values[index];
      keys[index] = (String)key;
      values[index] = (Integer)value;

      return iobj;
    }
  }

  public Object get(Object key) {
    int index = hashCode1(key);
    if (keys[index] != null) {
      return values[index];
    }
    else {
      return null;
    }
  }

  public Object remove(Object key) {
    int index = hashCode1(key);
    if (keys[index] == null) {
      return null;
    }
    else {
      Integer iRet = values[index];
      keys[index] = null;
      values[index] = null;
      return iRet;
    }
  }
}

