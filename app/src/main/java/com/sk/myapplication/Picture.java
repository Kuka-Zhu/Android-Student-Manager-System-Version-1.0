package com.sk.myapplication;

import android.graphics.drawable.Drawable;

public class Picture {
    public Drawable drawable;
    public String label;

    public Picture() {
    }

    public Picture(Drawable drawable, String label) {
        this.drawable = drawable;
        this.label = label;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "drawable=" + drawable +
                ", label='" + label + '\'' +
                '}';
    }
}
