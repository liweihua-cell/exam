package designPattern.strategyPattern;

/**
 * @author liweihua
 * @classname CashRebate
 * @description TODO
 * @date 2023/11/6 11:39
 */
public class CashRebate extends CashStrategy {
    private double moneyRebate = 0;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }

}
