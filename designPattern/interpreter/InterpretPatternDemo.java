import impl.Expression;
import impl.TerminalExpression;
import impl.AndExpression;
import impl.OrExpression;

public class InterpretPatternDemo {
  public static Expression GetMaleExpression() {
    Expression robert = new TerminalExpression("Robert");
    Expression john = new TerminalExpression("John");

    return new OrExpression(robert, john);
  }

  public static Expression GetMarriedWomanExpression() {
    Expression julie = new TerminalExpression("Julie");
    Expression married = new TerminalExpression("Married");

    return new AndExpression(julie, married);
  }

  public static void main(String[] args) {
    Expression isMale = GetMaleExpression();
    Expression isMarriedWoman = GetMarriedWomanExpression();

    System.out.println("John is male ? " + isMale.interpret("John"));
    System.out.println("Julie is married ? " + isMarriedWoman.interpret("Married Julie"));
  }
}

