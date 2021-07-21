package DesignPatterns.PhoneAbstractFactory;

public class Client {

    private int age;

    private String phoneModel;

    public Client(int age, String phoneModel) {
        this.age = age;
        this.phoneModel = phoneModel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }
}
