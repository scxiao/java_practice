import impl.User;
import impl.ChatRoom;

public class MediatorPatternDemo {
  public static void main(String[] args) {
    User robert = new User("Robert");
    User john = new User("John");

    robert.sendMessage("Hi, John!");
    john.sendMessage("Hi, Robert!");

    return;
  }
}

