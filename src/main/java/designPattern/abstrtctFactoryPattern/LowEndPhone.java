package designPattern.abstrtctFactoryPattern;

class LowEndPhone implements Phone {
    @Override
    public void produce() {
        System.out.println("Producing low-end phone");
    }
}