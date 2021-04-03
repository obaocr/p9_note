package com.ocr.p9_note.service;

import com.ocr.p9_note.model.PatientNote;

import java.util.List;

/**
 * Interface for note services
 */
public interface NoteService {

    List<PatientNote> getAllNotes();
    PatientNote addNote(PatientNote note);
    Boolean updateNote(PatientNote note);
    List<PatientNote> getNoteByPatientId(Integer Id);
    PatientNote getNoteByNoteId(String Id);
    Boolean deleteNoteByNoteId(String noteId);
}
