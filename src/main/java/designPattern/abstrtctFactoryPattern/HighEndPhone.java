package designPattern.abstrtctFactoryPattern;

class HighEndPhone implements Phone {
    @Override
    public void produce() {
        System.out.println("Producing high-end phone");
    }
}