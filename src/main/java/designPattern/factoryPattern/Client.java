package designPattern.factoryPattern;

public class Client {
    public static void main(String[] args) {
        // 创建具体工厂对象
        Factory factoryA = new ConcreteFactoryA();
        Factory factoryB = new ConcreteFactoryB();

        // 使用具体工厂创建产品对象
        Product productA = factoryA.createProduct();
        Product productB = factoryB.createProduct();

        // 生产产品
        productA.produce();
        productB.produce();
    }
}