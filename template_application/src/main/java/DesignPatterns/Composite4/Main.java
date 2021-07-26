package DesignPatterns.Composite4;

import DesignPatterns.Composite2.P;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        Body body = new Body();
        Paragraph p = new Paragraph();
        Text text = new Text("Hello world");
        p.add(text);
        body.add(p);
        html.add(body);
        System.out.println(html.render());


    }
}
