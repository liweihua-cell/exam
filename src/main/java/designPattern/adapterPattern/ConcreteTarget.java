package designPattern.adapterPattern;

/**
 * @author liweihua
 * @classname ConcreteTarget
 * @description TODO
 * @date 2023/11/6 11:08
 */
//具体目标类，只提供普通功能
public class ConcreteTarget implements Target {
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
