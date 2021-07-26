package DesignPatterns.Proxy;

public class Main {
    public static void main(String[] args) {
        BadClient badClient = new BadClient();
        badClient.execute();
    }
}
