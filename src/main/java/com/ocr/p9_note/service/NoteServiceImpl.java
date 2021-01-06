package com.ocr.p9_note.service;

import com.ocr.p9_note.model.Note;
import com.ocr.p9_note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements  NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        List<Note> notes;
        notes = noteRepository.findAll();
        return notes;
    }
}
