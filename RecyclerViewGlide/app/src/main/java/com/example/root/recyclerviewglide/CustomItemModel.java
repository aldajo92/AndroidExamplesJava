package com.example.root.recyclerviewglide;

import java.util.List;

/**
 * Created by root on 15/06/17.
 */

public class CustomItemModel {

    private String title;

    private List<String> items;

    public CustomItemModel(String title, List<String> items) {
        this.title = title;
        this.items = items;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getItems() {
        return items;
    }
}
