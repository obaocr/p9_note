package com.ocr.p9_note.repository;

import com.ocr.p9_note.model.PatientNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<PatientNote, String> {
    public List<PatientNote> findPatientNoteByNoteId(Long NoteId);
}
