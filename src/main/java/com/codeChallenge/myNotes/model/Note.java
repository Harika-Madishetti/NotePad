package com.codeChallenge.myNotes.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@CrossOrigin(origins = "http://localhost:3000")
@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;


    public Note() {
    }

    public Note(int id,String title, String content) {
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
