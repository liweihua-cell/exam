package designPattern.abstrtctFactoryPattern;

class LowEndFactory implements Factory {
    @Override
    public Computer createComputer() {
        return new LowEndComputer();
    }

    @Override
    public Phone createPhone() {
        return new LowEndPhone();
    }
}