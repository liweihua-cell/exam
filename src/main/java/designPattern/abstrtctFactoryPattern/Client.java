package designPattern.abstrtctFactoryPattern;

public class Client {
    public static void main(String[] args) {
        Factory highEndFactory = new HighEndFactory();
        Computer highEndComputer = highEndFactory.createComputer();
        Phone highEndPhone = highEndFactory.createPhone();

        highEndComputer.produce();
        highEndPhone.produce();
        
        Factory lowEndFactory = new LowEndFactory();
        Computer lowEndComputer = lowEndFactory.createComputer();
        Phone lowEndPhone = lowEndFactory.createPhone();

        lowEndComputer.produce();
        lowEndPhone.produce();
    }
}