package DesignPatterns.PhoneAbstractFactory;

public class IphoneFactory implements PhoneFactory {

    @Override
    public ModernPhone produceModernPhone() {
        return new IphoneLastGen();
    }

    @Override
    public OldfashionedPhone produceOldFashionedPhone() {
        return new IphoneFirstGen();
    }
}
