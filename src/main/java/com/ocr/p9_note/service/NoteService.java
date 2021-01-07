package com.ocr.p9_note.service;

import com.ocr.p9_note.model.PatientNote;

import java.util.List;

public interface NoteService {

    List<PatientNote> getAllNotes();
    Long addNote(PatientNote note);
    Boolean updateNote(PatientNote note);
    List<PatientNote> getNoteByPatientId(Integer Id);
    PatientNote getNoteByNoteId(Long Id);
    Boolean deleteNoteByNoteId(Long noteId);
}
