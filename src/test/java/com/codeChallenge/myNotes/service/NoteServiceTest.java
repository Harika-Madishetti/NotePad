package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.Dao.MyNotesDao;
import com.codeChallenge.myNotes.Dao.Notes;
import com.codeChallenge.myNotes.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private Notes notes;


    @Test
    public void getAllNotesTest() {

        Mockito.when(noteService.getAllNotes()).thenReturn(Arrays.asList(new Note(1, "mynotes", "this is my first service layer test")));
        List<Note> notesList = noteService.getAllNotes();
        assertEquals(1, notesList.get(0).getId());
        assertEquals("mynotes", notesList.get(0).getTitle());
        assertEquals("this is my first service layer test", notesList.get(0).getContent());
    }
}
