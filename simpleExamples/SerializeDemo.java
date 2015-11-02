import java.io.*;
import impl.Student;
import impl.Undergraduate;
import impl.Graduate;

public class SerializeDemo {
  public static void print(Student s) {
    s.calcTuition();
    s.printInfo();
    s.printTuition();
  }

  public static void main(String[] args)
  {
    if (args.length != 2) {
      System.out.println("Usage: java Serialize fileName r(0)/w(1)");
      return;
    }

    int flag = Integer.parseInt(args[1]);
    Student s;
    File f = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    try {
      if (flag == 0) { // read
        f = new File(args[0]);
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        s = (Graduate)ois.readObject();
      }
      else { // write 
        s = new Graduate("Tom", 23);
        f = new File(args[0]);
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
      }
      if (fis != null) {
        fis.close();
      }

      if (ois != null) {
        ois.close();
      }

      if (fos != null) {
        fos.close();
      }

      if (oos != null) {
        oos.close();
      }

      print(s);
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    catch(ClassNotFoundException ce) {
      ce.printStackTrace();
    }
//    finally {
//      if (fis != null) {
//        fis.close();
//      }
//
//      if (ois != null) {
//        ois.close();
//      }
//
//      if (fos != null) {
//        fos.close();
//      }
//
//      if (oos != null) {
//        oos.close();
//      }
//    }
  }
}


