import java.util.*;

// base interface for all meal plans
interface MealPlan {
    String getPlanName();

    int getCalories();
}

// different meal plan types
class VegetarianMeal implements MealPlan {
    public String getPlanName() {
        return "Vegetarian Meal";
    }

    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {
    public String getPlanName() {
        return "Vegan Meal";
    }

    public int getCalories() {
        return 1600;
    }
}

class KetoMeal implements MealPlan {
    public String getPlanName() {
        return "Keto Meal";
    }

    public int getCalories() {
        return 2000;
    }
}

class HighProteinMeal implements MealPlan {
    public String getPlanName() {
        return "High Protein Meal";
    }

    public int getCalories() {
        return 2200;
    }
}

// generic Meal class restricted to MealPlan types
class Meal<T extends MealPlan> {
    private T mealPlan;

    // constructor to assign meal plan
    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    T getMealPlan() {
        return mealPlan;
    }

    void displayMeal() {
        System.out.println("Meal Type: " + mealPlan.getPlanName());
        System.out.println("Calories: " + mealPlan.getCalories());
    }
}

public class PersonalizedMealPlanGenerator {

    // generic method to validate and generate meal plan
    static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        return new Meal<>(plan);
    }

    public static void main(String[] args) {

        // creating different meal plans
        Meal<VegetarianMeal> vegMeal = generateMealPlan(new VegetarianMeal());

        Meal<VeganMeal> veganMeal = generateMealPlan(new VeganMeal());

        Meal<KetoMeal> ketoMeal = generateMealPlan(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal = generateMealPlan(new HighProteinMeal());

        // displaying generated meal plans
        vegMeal.displayMeal();
        System.out.println();

        veganMeal.displayMeal();
        System.out.println();

        ketoMeal.displayMeal();
        System.out.println();

        proteinMeal.displayMeal();
    }
}
