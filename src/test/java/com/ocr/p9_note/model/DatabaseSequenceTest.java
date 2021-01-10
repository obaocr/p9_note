package com.ocr.p9_note.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseSequenceTest {

    @Test
    void databaseSequenceTest() {
        DatabaseSequence databaseSequence = new DatabaseSequence();
        databaseSequence.setId("1");
        databaseSequence.setSeq(1);
        assertTrue(databaseSequence != null);
        assertTrue(databaseSequence.getId() == "1");
        assertTrue(databaseSequence.getSeq() == 1);
    }
}
