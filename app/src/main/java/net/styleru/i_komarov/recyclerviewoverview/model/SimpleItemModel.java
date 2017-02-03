package net.styleru.i_komarov.recyclerviewoverview.model;

/**
 * Created by i_komarov on 03.02.17.
 */

public class SimpleItemModel {

    private int position;
    private String title;
    private String subtitle;

    public SimpleItemModel(int position, String title, String subtitle) {
        this.position = position;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "SimpleItemModel{" +
                "position=" + position +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
