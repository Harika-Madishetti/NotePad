package com.codeChallenge.myNotes.model;

public class Note {
    private int id;
    private String title;
    private String content;


    public Note() {
    }

    public Note(int id, String title, String content) {
        super();
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
