package designPattern.factoryPattern;

class ConcreteProductA implements Product {
    @Override
    public void produce() {
        System.out.println("Producing Product A");
    }
}