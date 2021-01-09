package com.ocr.p9_note.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "note")
public class PatientNote {

    @Transient
    public static final String SEQUENCE_NAME = "notes_sequence";

    @Id
    private String noteId;
    private Integer patientId;
    @Size(min = 3, max = 100, message = "title size between 3 and 100")
    private String title;
    private String note;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public PatientNote() {
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "PatientNote{" +
                "noteId=" + noteId +
                ", patientId=" + patientId +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
