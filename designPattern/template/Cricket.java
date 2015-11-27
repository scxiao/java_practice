package impl;

import impl.Game;

public class Cricket extends Game {
  void endPlay() {
    System.out.println("Cricket Game Finished");
  }

  void initialize() {
    System.out.println("Cricket Game initialized");
  }

  void startPlay() {
    System.out.println("Cricket Game Started.");
  }
}

