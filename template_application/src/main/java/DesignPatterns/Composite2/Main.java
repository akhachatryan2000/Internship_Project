package DesignPatterns.Composite2;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        Body body = new Body();
        P pa = new P();
        Text text = new Text("Hello World");
        pa.addTags(text);
        body.addTags(pa);
        html.addTags(body);

        System.out.println(html.render());
    }
}
