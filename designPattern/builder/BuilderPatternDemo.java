import impl.MealBuilder;
import impl.Meal;

public class BuilderPatternDemo {
  public static void main(String[] args) {
    MealBuilder mb = new MealBuilder();

    Meal vegMeal = mb.prepareVegMeal();
    System.out.println("Veg meal:");
    vegMeal.showItems();
    System.out.println("Total cost: " + vegMeal.getCost());

    Meal nonVegMeal = mb.prepareNonVegMeal();
    System.out.println("NonVeg meal:");
    nonVegMeal.showItems();
    System.out.println("Total cost: " + nonVegMeal.getCost());
  }
}

