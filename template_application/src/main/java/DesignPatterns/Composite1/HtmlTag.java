package DesignPatterns.Composite1;

import java.util.ArrayList;
import java.util.List;

public abstract class HtmlTag extends HtmlNode {

    private String tagName;

    private List<HtmlNode> elements = new ArrayList<>();


    public HtmlTag(String tagName) {
        this.tagName = tagName;
    }

    public void addChild(HtmlNode component) {
        elements.add(component);

    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(tagName + " ");
        for (HtmlNode element : elements
        ) {
            sb.append(element.render() + " ");
        }
        sb.append(tagName + " ");
        return sb.toString();
    }
}
