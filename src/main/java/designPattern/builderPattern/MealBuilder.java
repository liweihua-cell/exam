package designPattern.builderPattern;

/**
 * @author liweihua
 * @classname MealBuilder
 * @description TODO
 * @date 2023/11/6 10:12
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
