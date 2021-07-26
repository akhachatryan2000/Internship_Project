package DesignPatterns.Composite4;

public class Text extends LeafNode {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String render() {
        return text;
    }
}
