package DesignPatterns.Composite1;

public class Text extends LeafNode { //fragment of text
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String render() {
        return text;
    }
}
