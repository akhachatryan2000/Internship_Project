package DesignPatterns.PhoneAbstractFactory;

public class MobileStore {
    private Client client;
    private OldfashionedPhone oldfashionedPhone;
    private ModernPhone modernPhone;

    MobileStore(PhoneFactory factory, Client client) {
        this.client = client;
        oldfashionedPhone = factory.produceOldFashionedPhone();
        modernPhone = factory.produceModernPhone();
    }

    public void serveClient() {
        if (client.getAge() > 50 && client.getPhoneModel() == "Samsung") {
            System.out.println("The client needs Samsung first generation");
        } else if (client.getAge() < 50 && client.getPhoneModel() == "Iphone") {
            System.out.println("The client needs Last generation iphone");
        } else if (client.getAge() < 50 && client.getPhoneModel() == "Samsung") {
            System.out.println("The client needs last generation Samsung");
        } else if (client.getAge() > 50 && client.getPhoneModel() == "Iphone") {
            System.out.println("The client needs first generation iphone");
        }
    }

}
