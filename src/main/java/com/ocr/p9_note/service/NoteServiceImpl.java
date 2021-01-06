package com.ocr.p9_note.service;

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

    @Override
    public List<PatientNote> getAllNotes() {
        List<PatientNote> notes;
        notes = noteRepository.findAll();
        return notes;
    }

    @Override
    public String addNote(PatientNote note) {
        logger.debug("P9 addNote :" + note.toString());
        return noteRepository.save(note).getId();
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
}
