package DesignPatterns.PhoneAbstractFactory;

public class SamsungFactory implements PhoneFactory{
    @Override
    public ModernPhone produceModernPhone() {
        return new SamsungLastGen();
    }

    @Override
    public OldfashionedPhone produceOldFashionedPhone() {
        return new SamsungFirstGen();
    }
}
