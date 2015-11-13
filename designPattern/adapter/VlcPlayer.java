package impl;

import impl.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name: " + fileName);
  }

  public void playMp4(String fileName) {
  }
}

