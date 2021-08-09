package DesignPatterns.Composite456;
import java.util.ArrayList;
import java.util.List;

public class HtmlTag extends HtmlNode {

    private String name;

    List<HtmlNode> elements = new ArrayList<>();

    public HtmlTag(String name) {
        this.name = name;
    }

    @Override
    public String render() {
        return null;
    }
}
