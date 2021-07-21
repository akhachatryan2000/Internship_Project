package DesignPatterns.PhoneAbstractFactory;

public class Main {
    public static void main(String[] args) {
        PhoneFactory factory = new IphoneFactory();
        Client client = new Client(56, "Samsung");
        MobileStore store = new MobileStore(factory, client);
        store.serveClient();

        PhoneFactory factory1 = new SamsungFactory();
        Client client1 = new Client(15, "Iphone");
        MobileStore store1 = new MobileStore(factory1, client1);
        store1.serveClient();
    }
}
