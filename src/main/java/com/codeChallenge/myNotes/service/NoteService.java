package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.model.Note;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {
        private List<Note> notes =Arrays.asList(
                new Note("my notes","Hi, I am fine here"),
                new Note("my notes - 2","Hi , I should get this"),
                new Note("my notes - 3","Hi , I should for sure get it")
        );
        public List<Note> getAllNotes(){
            return notes;
        }
}
