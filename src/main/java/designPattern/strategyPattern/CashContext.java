package designPattern.strategyPattern;

/**
 * @author liweihua
 * @classname CashContext
 * @description TODO
 * @date 2023/11/6 11:39
 */
public class CashContext {
    private CashStrategy cs;

    public CashContext(CashStrategy cs) {
        this.cs = cs;
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
