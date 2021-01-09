package com.ocr.p9_note.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PatientNoteTest {

    @Test
    void patientNoteTest() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        assertTrue(patientNote != null);
        assertTrue(patientNote.getNoteId() == "1");
        assertTrue(patientNote.getPatientId() == 1);
        assertTrue(patientNote.getTitle() == "test");
        assertTrue(patientNote.getNote() == "test de note");

    }
}
