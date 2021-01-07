package com.ocr.p9_note.service;

import com.mongodb.WriteResult;
import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements  NoteService {

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
    public Long addNote(PatientNote note) {
        logger.debug("P9 addNote :" + note.toString());
        note.setNoteId(sequenceGeneratorService.generateSequence(PatientNote.SEQUENCE_NAME));
        return noteRepository.save(note).getNoteId();
    }

    @Override
    public Boolean updateNote(PatientNote note) {
        logger.debug("P9 updateNote :" + note.toString());
        noteRepository.save(note);
        return true;
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
    public Boolean deleteNoteByNoteId(Long noteId) {
        System.out.println("****** deleteNoteByNoteId Id = " + noteId);
        logger.debug("P9 deleteNoteByNoteId :" + noteId);
        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("noteId").is(noteId));
        mongoOperations.remove(searchQuery, PatientNote.class);
        return true;
    }

}
