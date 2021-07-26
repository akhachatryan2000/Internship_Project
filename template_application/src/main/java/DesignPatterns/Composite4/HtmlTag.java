package DesignPatterns.Composite4;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public abstract class HtmlTag extends HtmlNode {
    private String tagName;

    List<HtmlNode> elements = new ArrayList<>();

    public HtmlTag(String tagName) {
        this.tagName = tagName;
    }

    public void add(HtmlNode element) {
        elements.add(element);
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
