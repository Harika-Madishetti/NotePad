package com.codeChallenge.myNotes.Dao;

import com.codeChallenge.myNotes.model.Note;

import java.util.List;

public interface Notes {
    List<Note> getAllNotes();

    Note getNotesById(int id);

    void insertNotes(Note note);

    void removeNotesById(int id);

    void updateNotes(Note note);
}
