package com.ocr.p9_note.service;

import com.ocr.p9_note.model.PatientNote;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration
@SpringBootTest
public class PatientNoteServiceIntgTest {

    @Autowired
    private NoteService noteService;

    @Disabled
    @Test
    void testAddNote() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        String result = noteService.addNote(patientNote).getNoteId();
        assertTrue(noteService.getNoteByNoteId(result.toString()) != null);
    }

    @Disabled
    @Test
    void addAndDeleteNote() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        String result = noteService.addNote(patientNote).getNoteId();
        assertTrue(noteService.getNoteByNoteId(result.toString()) != null);
        assertTrue(noteService.deleteNoteByNoteId(result.toString()) == true);
    }
}