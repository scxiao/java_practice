package impl;

import impl.MediaAdapter;

public class AudioPlayer implements MediaPlayer {
  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("Playing mp3 file. Name: " + fileName);
    }
    else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
      MediaAdapter ma = new MediaAdapter(audioType);
      ma.play(audioType, fileName);
    }
    else {
      System.out.println("Invalid media. " + audioType + " format not supported.");
    }
  }
}

