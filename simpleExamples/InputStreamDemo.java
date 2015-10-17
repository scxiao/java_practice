import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
   public static void main(String[] args) throws Exception {

      InputStream is = null;
      File inputFile = null;
      char c;

      try{
         // new input stream created
         inputFile = new File("test.txt");
         is = new FileInputStream(inputFile);
         System.out.println("Characters printed:");
         byte[] buffer=new byte[(int)inputFile.length()];

         // read stream data into buffer
         is.read(buffer);

         // for each byte in the buffer
         for(byte b:buffer)
         {
            // convert byte to character
            c=(char)b;

            // prints character
            System.out.print(c);
         }
      }catch(Exception e){
         // if any I/O error occurs
         e.printStackTrace();
      }finally{
         // releases system resources associated with this stream
         if(is!=null)
            is.close();
      }
   }
}
