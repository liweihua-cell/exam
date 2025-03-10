package designPattern.strategyPattern;

import java.util.Scanner;

/**
 * @author liweihua
 * @classname Client
 * @description TODO
 * @date 2023/11/6 11:40
 */
public class Client {
    static double total = 0.0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入优惠方案：");
        String str = cin.next();
        CashContext cc = null;

        switch (str) {
            case "正常收费":
                cc = new CashContext(new CashNormal());
                break;
            case "满300返100":
                cc = new CashContext(new CashRetrun(300, 100));
                break;
            case "打8折":
                cc = new CashContext(new CashRebate(0.8));
                break;
        }

        System.out.println("请输入消费金额：");
        double price = cin.nextInt();
        total = cc.getResult(price);

        System.out.println("最后共消费：" + total);
        cin.close();
    }
}
