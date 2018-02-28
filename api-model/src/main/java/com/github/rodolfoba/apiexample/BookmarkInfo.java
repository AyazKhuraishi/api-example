package com.github.rodolfoba.apiexample;

public class BookmarkInfo {

    private String name;

    private String link;

    public BookmarkInfo() {
        super();
    }

    public BookmarkInfo(String name, String link) {
        super();
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BookmarkInfo [name=" + name + ", link=" + link + "]";
    }

}
