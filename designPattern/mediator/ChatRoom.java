package impl;

import java.util.Date;
import impl.UserInterface;

public class ChatRoom {
  public static void showMessage(UserInterface ui, String msg) {
    System.out.println(new Date().toString() + " [" + ui.getName() + "] : " + msg);
  }
}

