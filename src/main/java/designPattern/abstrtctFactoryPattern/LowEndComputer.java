package designPattern.abstrtctFactoryPattern;

class LowEndComputer implements Computer {
    @Override
    public void produce() {
        System.out.println("Producing low-end computer");
    }
}
