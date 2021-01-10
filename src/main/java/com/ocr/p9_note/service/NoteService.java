package com.ocr.p9_note.service;

import com.ocr.p9_note.model.PatientNote;

import java.util.List;

public interface NoteService {

    List<PatientNote> getAllNotes();
    String addNote(PatientNote note);
    Boolean updateNote(PatientNote note);
    List<PatientNote> getNoteByPatientId(Integer Id);
    List<PatientNote> getNoteByNoteId(String Id);
    Boolean deleteNoteByNoteId(String noteId);
}
