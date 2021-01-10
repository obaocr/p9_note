package com.ocr.p9_note.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<PatientNote> getAllNotes() {
        List<PatientNote> notes;
        notes = noteRepository.findAll();
        return notes;
    }

    @Override
    public String addNote(PatientNote note) {
        logger.debug("P9 addNote :" + note.toString());
        Long seqValue = sequenceGeneratorService.generateSequence(PatientNote.SEQUENCE_NAME);
        note.setNoteId(seqValue.toString());
        LocalDateTime dtUpdate = LocalDateTime.now();
        note.setCreateDate(dtUpdate);
        note.setUpdateDate(dtUpdate);
        return noteRepository.save(note).getNoteId();
    }

    @Override
    public Boolean updateNote(PatientNote note) {
        logger.debug("P9 updateNote :" + note.toString());
        Query query = new Query();
        query.addCriteria(Criteria.where("noteId").is(note.getNoteId()));
        PatientNote patientNote = mongoOperations.findOne(query, PatientNote.class);
        if(note.getUpdateDate() == null) {
            note.setUpdateDate(LocalDateTime.now());
        }
        if (patientNote != null) {
            Update update = new Update();
            update.set("title", note.getTitle());
            update.set("note", note.getNote());
            update.set("updateDate", note.getUpdateDate().toString());
            UpdateResult updateResult = mongoOperations.updateFirst(query, update, PatientNote.class);
            if (updateResult.getModifiedCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<PatientNote> getNoteByPatientId(Integer patientId) {
        logger.debug("P9 getNoteByPatientId :" + patientId);
        List<PatientNote> patientNotes = new ArrayList<>();
        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("patientId").is(patientId));
        patientNotes = mongoOperations.find(searchQuery, PatientNote.class);
        return patientNotes;
    }

    @Override
    public List<PatientNote> getNoteByNoteId(String noteId) {
        logger.debug("P9 getNoteByNoteId :" + noteId);
        return noteRepository.findPatientNoteByNoteId(noteId);
    }

    @Override
    public Boolean deleteNoteByNoteId(String noteId) {
        logger.debug("P9 deleteNoteByNoteId :" + noteId);
        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("noteId").is(noteId));
        DeleteResult deleteResult = mongoOperations.remove(searchQuery, PatientNote.class);
        if (deleteResult.getDeletedCount() > 0) {
            return true;
        }
        return false;
    }
}
