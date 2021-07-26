package DesignPatterns.Composite2;

import java.util.ArrayList;
import java.util.List;

public abstract class HtmlTag extends HtmlNode {

    private String tagName;

    private List<HtmlNode> elements = new ArrayList<>();

    public HtmlTag(String tagName) {
        this.tagName = tagName;
    }

    public void addTags(HtmlNode component) {
        elements.add(component);
    }

    @Override
    public String render() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tagName + " ");
        for (HtmlNode node : elements
        ) {
            stringBuilder.append(node + " ");

        }
        stringBuilder.append(tagName + " ");
        return stringBuilder.toString();
    }
}
