package DesignPatterns.Composite1;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        Body body = new Body();
        P paragraph = new P();
        Text text = new Text("Hello World");
        paragraph.addChild(text);
        body.addChild(paragraph);
        html.addChild(body);

        System.out.println(html.render());


    }
}
