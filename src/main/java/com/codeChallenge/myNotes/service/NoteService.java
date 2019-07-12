package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.Dao.MyNotesDao;
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
    private MyNotesDao myNotesDao;

    public List<Note> getAllNotes() {
        return myNotesDao.getAllNotes();
    }

    public Note getNote(int id) {
        return myNotesDao.getNotesById(id);
    }

    public void addNote(Note note) {
        myNotesDao.insertNotes(note);
    }

    public void updateNote(Note note) {
        myNotesDao.updateNotes(note);
    }

    public void deleteNote(int id) {
        myNotesDao.removeNotesById(id);
    }
}
