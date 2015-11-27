package impl;

import impl.Game;

public class Football extends Game {
  void endPlay() {
    System.out.println("Football Game Finished");
  }

  void initialize() {
    System.out.println("Football Game initialized");
  }

  void startPlay() {
    System.out.println("Football Game Started.");
  }
}

