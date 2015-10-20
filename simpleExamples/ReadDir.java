import java.io.File;

public class ReadDir {
  public static void main(String[] args) {
    File file = null;
    String[] paths;

    String dir = new String();
    if (args.length == 0) {
      dir = dir + ".";
    }
    else {
      dir = args[0];
    }
    try {
      file = new File(dir);
      paths = file.list();

      for (String path: paths) {
        System.out.println(path);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

