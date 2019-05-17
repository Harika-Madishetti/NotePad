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
        public Note mapRow(ResultSet resultSet, int i) throws SQLException {
            Note mynotes = new Note();
            mynotes.setId(resultSet.getInt("id"));
            mynotes.setTitle(resultSet.getString("title"));
            mynotes.setContent(resultSet.getString("content"));
            return mynotes;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        final String sql = "SELECT id,title, content FROM Notes";
        List<Note> notes = jdbcTemplate.query(sql, new NoteRowMapper());
        return notes;
    }

    @Override
    public Note getNotesById(int id) {
        final String sql = "SELECT id,title, content FROM Notes where id = ?";
        Note myNotes = jdbcTemplate.queryForObject(sql, new NoteRowMapper(), id);
        return myNotes;
    }

    @Override
    public void insertNotes(Note note) {
        final String sql = "INSERT INTO Notes (title,content) VALUES (?,?)";
        final String title = note.getTitle();
        final String content = note.getContent();
        jdbcTemplate.update(sql, new Object[]{title, content});
    }


    @Override
    public void updateNotes(Note note) {
        final String sql = "UPDATE Notes SET title =? , content = ? where id = ?";
        final int id = note.getId();
        final String title = note.getTitle();
        final String content = note.getContent();
        jdbcTemplate.update(sql, new Object[]{title, content, id});

    }

    @Override
    public void removeNotesById(int id) {
        final String sql = "DELETE FROM Notes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
