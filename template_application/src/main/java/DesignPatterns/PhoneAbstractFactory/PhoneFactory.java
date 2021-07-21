package DesignPatterns.PhoneAbstractFactory;

public interface PhoneFactory {
    ModernPhone produceModernPhone();

    OldfashionedPhone produceOldFashionedPhone();

}
