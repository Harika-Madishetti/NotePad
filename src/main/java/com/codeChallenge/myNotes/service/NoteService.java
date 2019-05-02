package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>(Arrays.asList(
            new Note("mynotes", "Hi, I am fine here"),
            new Note("mynotes - 2", "Hi , I should get this"),
            new Note("mynotes - 3", "Hi , I should for sure get it")
    ));

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNote(String title) {
        return notes.stream().filter(notes -> notes.gettitle().equals(title)).findFirst().get();
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}
