package DesignPatterns.Composite;

public class Text extends LeafNode{
    protected String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}
