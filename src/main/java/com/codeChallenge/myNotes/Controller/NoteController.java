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
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }
}
