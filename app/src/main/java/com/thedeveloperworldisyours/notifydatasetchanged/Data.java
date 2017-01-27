package com.thedeveloperworldisyours.notifydatasetchanged;

/**
 * Created by javierg on 27/01/2017.
 */

public class Data {
    private String text;
    private boolean selected;

    public Data(String text, boolean selected) {
        this.text = text;
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
