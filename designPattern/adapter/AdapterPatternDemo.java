import impl.AudioPlayer;

public class AdapterPatternDemo {
  public static void main(String[] args) {
    AudioPlayer ap = new AudioPlayer();

    ap.play("mp3", "Beyond the horizon.mp3");
    ap.play("mp4", "alone.mp4");
    ap.play("vlc", "far far away.vlc");
    ap.play("avi", "mind me.avi");

    return;
  }
}
