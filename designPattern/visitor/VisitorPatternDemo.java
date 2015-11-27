import impl.ComputerPart;
import impl.Computer;
import impl.ComputerPartDisplayVisitor;

public class VisitorPatternDemo {
  public static void main(String[] args) {
    ComputerPart computer = new Computer();

    computer.accept(new ComputerPartDisplayVisitor());
  }
}

