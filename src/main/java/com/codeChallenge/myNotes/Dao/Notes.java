package com.codeChallenge.myNotes.Dao;

import com.codeChallenge.myNotes.model.Note;

import java.util.List;

public interface Notes {
    List<Note> getAllNotes();

    Note getNotesByTitle(int id);

    void insertNotesByTitle(Note note);

    void removeNotesByTitle(int id);

    void updateNotesByTitle(Note note);
}
