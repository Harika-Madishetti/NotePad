package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.Dao.Notes;
import com.codeChallenge.myNotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    @Qualifier("MySql")
    private Notes notes;

    public List<Note> getAllNotes() {
        return this.notes.getAllNotes();
    }

    public Note getNote(String title) {
        return this.notes.getNotesByTitle(title);
    }

    public void addNote(Note note) {
        this.notes.insertNotesByTitle(note);
    }

    public void updateNote(String title, Note note) {
        this.notes.updateNotesByTitle(title, note);
    }

    public void deleteNote(String title, Note note) {
        this.notes.removeNotesByTitle(title, note);
    }
}
