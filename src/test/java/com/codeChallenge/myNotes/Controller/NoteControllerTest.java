package com.codeChallenge.myNotes.Controller;

import com.codeChallenge.myNotes.model.Note;
import com.codeChallenge.myNotes.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = NoteController.class, secure = false)
public class NoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    public void shouldGetSingleNotes() throws Exception {
        Note mockNotes = new Note(1, "mynotes", "Hi I am adding unit tests for GET Rest calls");
        when(noteService.getNote(Mockito.anyInt())).thenReturn(mockNotes);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notes/1").accept(MediaType.APPLICATION_JSON);
        System.out.println(requestBuilder);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result);
        String expectedResult = "{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"}";
        assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void shouldGetAllNotes() throws Exception {
        List<Note> mockNotes = Arrays.asList(new Note(1, "mynotes", "Hi I am adding unit tests for GET Rest calls"),
                new Note(2, "mynotes1", "Hi I am adding another unit tests for GET all Rest calls"));
        when(noteService.getAllNotes()).thenReturn((List<Note>) mockNotes);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notes").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                                   .andReturn();
        String expectedResult = "[{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"},{\"title\":\"mynotes1\",\"content\":\"Hi I am adding another unit tests for GET all Rest calls\"}]";
        assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void shouldGetNotes() throws Exception {
        List<Note> mockNotes = Arrays.asList(new Note(1, "mynotes", "Hi I am adding unit tests for GET Rest calls"),
                new Note(2, "mynotes1", "Hi I am adding another unit tests for GET all Rest calls"));
        when(noteService.getAllNotes()).thenReturn(mockNotes);
        RequestBuilder request = MockMvcRequestBuilders.get("/notes").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"}," + "{\"title\":\"mynotes1\",\"content\":\"Hi I am adding another unit tests for GET all Rest calls\"}]"))
                .andReturn();
    }

    @Test
    public void shouldPostNotes() throws Exception {
        List<Note> mockNotes = Arrays.asList(new Note(1, "mynotes", "Hi I am adding unit tests for GET Restcalls"));
        when(noteService.getAllNotes()).thenReturn(mockNotes);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/notes")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"}")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldUpdateNotes() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .put("/notes/id")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"}")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldDeleteNotes() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .delete("/notes/6")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}
