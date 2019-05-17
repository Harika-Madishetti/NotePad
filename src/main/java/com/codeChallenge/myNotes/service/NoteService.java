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

    public Note getNote(int id) {
        return this.notes.getNotesById(id);
    }

    public void addNote(Note note) {
        this.notes.insertNotes(note);
    }

    public void updateNote(Note note) {
        this.notes.updateNotes(note);
    }

    public void deleteNote(int id) {
        this.notes.removeNotesById(id);
    }
}
