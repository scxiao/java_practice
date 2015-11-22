package impl;

import impl.ChatRoom;

public class User implements UserInterface {
  String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void sendMessage(String msg) {
    ChatRoom.showMessage(this, msg);
  }
}

