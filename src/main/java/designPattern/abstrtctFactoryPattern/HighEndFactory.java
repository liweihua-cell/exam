package designPattern.abstrtctFactoryPattern;

class HighEndFactory implements Factory {
    @Override
    public Computer createComputer() {
        return new HighEndComputer();
    }

    @Override
    public Phone createPhone() {
        return new HighEndPhone();
    }
}