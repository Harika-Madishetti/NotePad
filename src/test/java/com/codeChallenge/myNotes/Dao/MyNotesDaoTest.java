package com.codeChallenge.myNotes.Dao;


import com.codeChallenge.myNotes.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MyNotesDaoTest {

    @Autowired
    private MyNotesDao myNotesDao;

    @Test
    public void findAllUsers() {
        List<Note> notes = Arrays.asList(new Note(1, "mynotes", "Hi I am adding unit tests for GET Rest calls"),
                new Note(2, "mynotes1", "Hi I am adding another unit tests for GET all Rest calls"));
        assertNotNull(notes);
    }

    @Test
    public void should_get_users_by_id() {
        Note note1 = new Note(1,"we","we");
        myNotesDao.insertNotes(note1);
        assertTrue(myNotesDao.getAllNotes().size() > 3);
    }
}
