package com.ocr.p9_note.service;

import com.ocr.p9_note.model.PatientNote;

import java.util.List;

public interface NoteService {

    List<PatientNote> getAllNotes();
    Integer addNote(PatientNote note);

}
