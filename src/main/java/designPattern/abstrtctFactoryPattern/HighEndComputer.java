package designPattern.abstrtctFactoryPattern;

class HighEndComputer implements Computer {
    @Override
    public void produce() {
        System.out.println("Producing high-end computer");
    }
}