package com.ocr.p9_note.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "note")
public class PatientNote {

    // To set Id : PatientNote.setId(sequenceGenerator.generateSequence(PatientNote.SEQUENCE_NAME));

    @Transient
    public static final String SEQUENCE_NAME = "notes_sequence";

    @Id
    @Field("_id")
    private String id;
    @Field("patientId")
    @NotBlank
    private Integer patientId;
    @Field("title")
    @Size(min = 3, max = 100, message = "title size between 3 and 100")
    private String title;
    @NotBlank
    @Field("note")
    private String note;
    @Field("createDate")
    private LocalDateTime createDate;
    @Field("updateDate")
    private LocalDateTime updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", patientId=" + patientId +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
