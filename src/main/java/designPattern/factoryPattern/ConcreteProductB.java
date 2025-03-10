package designPattern.factoryPattern;

class ConcreteProductB implements Product {
    @Override
    public void produce() {
        System.out.println("Producing Product B");
    }
}