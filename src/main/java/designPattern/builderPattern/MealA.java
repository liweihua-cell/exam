package designPattern.builderPattern;

/**
 * @author liweihua
 * @classname MealA
 * @description TODO
 * @date 2023/11/6 10:14
 */
public class MealA extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("一盒薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }

}
