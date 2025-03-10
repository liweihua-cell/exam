package designPattern.strategyPattern;

/**
 * @author liweihua
 * @classname CashRetrun
 * @description TODO
 * @date 2023/11/6 11:39
 */
public class CashRetrun extends CashStrategy {

    private double moneyCondition = 0.0;
    private double moneyReturn = 0.0;


    public CashRetrun(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition)
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        //floor():向下取整
        return result;
    }

}
