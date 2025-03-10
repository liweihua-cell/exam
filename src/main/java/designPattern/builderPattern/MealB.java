package designPattern.builderPattern;

/**
 * @author liweihua
 * @classname MealB
 * @description TODO
 * @date 2023/11/6 10:15
 */
public class MealB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }
}
