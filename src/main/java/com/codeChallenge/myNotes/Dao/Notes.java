package com.codeChallenge.myNotes.Dao;

import com.codeChallenge.myNotes.model.Note;

import java.util.List;

public interface Notes {
    List<Note>  getAllNotes();
    Note getNotesByTitle(String title);
    void insertNotesByTitle(Note note);
    void removeNotesByTitle(String title, Note note);
    void updateNotesByTitle(String title, Note note);
}
