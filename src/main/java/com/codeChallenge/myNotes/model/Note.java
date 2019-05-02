package com.codeChallenge.myNotes.model;

public class Note {
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

    public String gettitle() {
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
