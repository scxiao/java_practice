package impl;

import impl.AdvancedMediaPlayer;
import impl.MediaPlayer;

class MediaAdapter implements MediaPlayer {
  private AdvancedMediaPlayer amp;

  public MediaAdapter(String audioType) {
    if (audioType.equalsIgnoreCase("vlc")) {
      amp = new VlcPlayer();
    }
    else if (audioType.equalsIgnoreCase("mp4")) {
      amp = new Mp4Player();
    }
  }

  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("vlc")) {
      amp.playVlc(fileName);
    }
    else if (audioType.equalsIgnoreCase("mp4")) {
      amp.playMp4(fileName);
    }
  }
}

