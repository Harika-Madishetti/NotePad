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

    @RequestMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping("/notes/{title}")
    public Note getNote(@PathVariable String title) {
        return noteService.getNote(title);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notes")
    //map this method to any req which is a post on /notes
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/notes/{title}")
    public void updateNote(@RequestBody Note note, @PathVariable String title){
        noteService.updateNote(title,note);
    }
}
