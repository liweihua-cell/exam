package designPattern.builderPattern;

/**
 * @author liweihua
 * @classname Waiter
 * @description TODO
 * @date 2023/11/6 10:17
 */
public class Waiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        //准备食物
        mealBuilder.buildFood();
        //准备饮料
        mealBuilder.buildDrink();
        //准备完毕，返回一个完整的套餐给客户
        return mealBuilder.getMeal();
    }
}
