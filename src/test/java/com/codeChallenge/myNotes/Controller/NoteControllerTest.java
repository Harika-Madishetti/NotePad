package com.codeChallenge.myNotes.Controller;

import com.codeChallenge.myNotes.model.Note;
import com.codeChallenge.myNotes.service.NoteService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = NoteController.class, secure = false)
public class NoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    Note mockNotes = new Note("mynotes", "Hi I am adding unit tests for GET Rest calls");

    @Test
    public void shouldGetSingleNotes() throws Exception {
        Mockito.when(noteService.getNote(Mockito.anyString())).thenReturn(mockNotes);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notes/mynotes").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "{\"title\":\"mynotes\",\"content\":\"Hi I am adding unit tests for GET Rest calls\"}";
        JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
    }

}
