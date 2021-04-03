package com.ocr.p9_note.utils;

import com.ocr.p9_note.model.PatientNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Check for PatientNote
 * */
public class Check {

    private static Logger logger = LoggerFactory.getLogger(Check.class);

    public static void checkNote(PatientNote patientNote) {
        if (patientNote == null || patientNote.getPatientId() == null || patientNote.getTitle().isEmpty() || patientNote.getNote().isEmpty()) {
            logger.error("PatientId and Title and note are mandatory for a PatientNote :" + patientNote.toString());
            throw new EntityIllegalArgumentException("All fields are mandatory for a PatientNote :" + patientNote.toString());
        }
    }
}
