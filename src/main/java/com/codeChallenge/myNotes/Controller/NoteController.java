package com.codeChallenge.myNotes.Controller;

import com.codeChallenge.myNotes.model.Note;
import com.codeChallenge.myNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public Note getNote(@PathVariable int id) {
        return noteService.getNote(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notes")
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/notes/{id}")
    public void updateNote(@RequestBody Note note) {
        noteService.updateNote(note);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/notes/{id}")
    public void deleteNote(@RequestBody Note note, @PathVariable int id) {
        noteService.deleteNote(id, note);
    }
}
