package com.codeChallenge.myNotes.service;

import com.codeChallenge.myNotes.Dao.MyNotesDao;
import com.codeChallenge.myNotes.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private MyNotesDao myNotesDao;

    Note note1 = new Note(1, "mynotes", "this is my first service layer test");

    @Test
    public void shouldCheckGetAllNotes() {
        when(myNotesDao.getAllNotes()).thenReturn(Arrays.asList(note1));
        List<Note> notesList = noteService.getAllNotes();
        assertEquals(1, notesList.get(0).getId());
        assertEquals("mynotes", notesList.get(0).getTitle());
        assertEquals("this is my first service layer test", notesList.get(0).getContent());
    }

    @Test
    public void shouldCheckGetSingleNote() {
        when(myNotesDao.getNotesById(anyInt())).thenReturn(note1);
        assertEquals(1, note1.getId());
        assertEquals("mynotes", note1.getTitle());
    }

    @Test
    public void shouldVerifyAddNote() {
        verify(myNotesDao, times(0)).insertNotes(note1);
        noteService.addNote(note1);
        verify(myNotesDao, times(1)).insertNotes(note1);
    }

    @Test
    public void shouldVerifyUpdateNote() {
        verify(myNotesDao, times(0)).updateNotes(note1);
        noteService.updateNote(note1);
        verify(myNotesDao, times(1)).updateNotes(note1);
    }

    @Test
    public void shouldVerifyDeleteNote() {
        verify(myNotesDao, times(0)).removeNotesById(anyInt());
        noteService.deleteNote(anyInt());
        verify(myNotesDao, times(1)).removeNotesById(anyInt());
    }
}
