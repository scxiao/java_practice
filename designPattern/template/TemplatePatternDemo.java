import impl.Football;
import impl.Cricket;
import impl.Game;

public class TemplatePatternDemo {
  public static void main(String[] args) {
    Game game = new Cricket();
    game.play();
    System.out.println();

    game = new Football();
    game.play();

    return;
  }
}

