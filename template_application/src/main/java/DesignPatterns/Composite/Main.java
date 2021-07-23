package DesignPatterns.Composite;

public class Main {
    public static void main(String[] args) {
        Html html= new Html();
        Body body= new Body();
        P p= new P();
        Text text= new Text("Helo World");
        p.addChild(text);
        body.addChild(p);
        html.addChild(body);
        System.out.println(html.render());
    }
}
