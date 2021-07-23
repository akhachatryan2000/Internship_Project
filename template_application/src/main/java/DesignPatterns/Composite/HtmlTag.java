package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class HtmlTag extends HtmlNode {
    protected String name;

    protected List<HtmlNode> elements = new ArrayList<>();

    public HtmlTag(String name) {
        this.name = name;
    }

    public void addChild(HtmlNode component) {
        elements.add(component);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " ");
        for (HtmlNode child : elements
        ) {
            sb.append(child.render());
        }
        sb.append(  " "+name + " ");
        return sb.toString();
    }
}
