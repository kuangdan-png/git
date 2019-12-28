package com.medicine.util;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-11-27-10:28
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.util
 */
public class LayuiTree<T> {
    private String title;
    private String id;
    private List<T> children;

    @Override
    public String toString() {
        return "LayuiTree{" +
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

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public LayuiTree() {
    }

    public LayuiTree(String title, String id, List<T> children) {
        this.title = title;
        this.id = id;
        this.children = children;
    }
}
