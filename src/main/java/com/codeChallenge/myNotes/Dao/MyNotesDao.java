package com.codeChallenge.myNotes.Dao;


import com.codeChallenge.myNotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("MySql")
public class MyNotesDao implements Notes {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class NoteRowMapper implements RowMapper<Note> {

        @Override
        public Note mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Note mynotes = new Note();
            mynotes.setTitle(resultSet.getString("title"));
            mynotes.setContent(resultSet.getString("content"));
            return mynotes;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        final String sql = "SELECT title, content FROM Notes";
        List<Note> notes = jdbcTemplate.query(sql, new NoteRowMapper());
        return notes;
    }

    @Override
    public Note getNotesByTitle(String title) {
        final String sql = "SELECT title, content FROM Notes where title = ?";
        Note myNotes = jdbcTemplate.queryForObject(sql, new NoteRowMapper(), title);
        return myNotes;
    }

    @Override
    public void insertNotesByTitle(Note note) {

    }

    @Override
    public void removeNotesByTitle(String title, Note note) {

    }

    @Override
    public void updateNotesByTitle(String title, Note note) {

    }
}
