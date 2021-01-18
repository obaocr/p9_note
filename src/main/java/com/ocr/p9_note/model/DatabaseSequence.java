package com.ocr.p9_note.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Model for the databases_sequence for Note ID
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

    public DatabaseSequence() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
