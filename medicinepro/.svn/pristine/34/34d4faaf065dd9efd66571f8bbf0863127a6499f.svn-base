package com.medicine.pojo;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-10:28
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.util
 */
public class LayuiTreeAuthority<T> {
    private String title;
    private String id;
    private  List<LayuiTreeAuthority<T>> children;

    @Override
    public String toString() {
        return "LayuiTreeAuthority{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", children=" + children +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LayuiTreeAuthority<T>> getChildren() {
        return children;
    }

    public void setChildren(List<LayuiTreeAuthority<T>> children) {
        this.children = children;
    }

    public LayuiTreeAuthority() {
    }

    public LayuiTreeAuthority(String title, String id, List<LayuiTreeAuthority<T>> children) {
        this.title = title;
        this.id = id;
        this.children = children;
    }

    public LayuiTreeAuthority(String title, String id) {
        this.title = title;
        this.id = id;
    }
}
