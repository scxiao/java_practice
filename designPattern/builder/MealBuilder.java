package impl;

import impl.Meal;
import impl.VegBurger;
import impl.CheckenBurger;
import impl.Coke;
import impl.Pepsi;

public class MealBuilder {
  public Meal prepareVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new VegBurger());
    meal.addItem(new Coke());

    return meal;
  }

  public Meal prepareNonVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new CheckenBurger());
    meal.addItem(new Pepsi());

    return meal;
  }
}

