package com.github.rodolfoba.apiexample;

public class Bookmark {

    private BookmarkId id;
    private String name;
    private String link;

    public Bookmark() {
        super();
    }

    public Bookmark(BookmarkId id, String name, String link) {
        super();
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public BookmarkId getId() {
        return id;
    }

    public void setId(BookmarkId id) {
        this.id = id;
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

}
