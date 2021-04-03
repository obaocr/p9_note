package com.ocr.p9_note.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.repository.NoteRepository;
import org.bson.BsonObjectId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class PatientNoteServiceTest {

    @Autowired
    private NoteService noteService;

    @MockBean
    private NoteRepository noteRepository;

    @MockBean
    private MongoOperations mongoOperations;

    @MockBean
    private SequenceGeneratorService sequenceGeneratorService;

    @TestConfiguration
    static class NoteServiceTestsContextConfiguration {

        @Bean
        public NoteService PatientNoteService() {
            return new NoteServiceImpl();
        }

    }

    @Test
    void patientNoteGetAll() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);
        Mockito.when(noteRepository.findAll()).thenReturn(patientNotes);
        long seq = 1;
        Mockito.when(sequenceGeneratorService.generateSequence(PatientNote.SEQUENCE_NAME)).thenReturn(seq);
        List<PatientNote> listPatientNotes = noteService.getAllNotes();
        assertTrue(listPatientNotes.size() > 0);
    }

    @Test
    void patientNoteGetByNoteId() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);
        Mockito.when(noteRepository.findPatientNoteByNoteId("1")).thenReturn(patientNotes);
        PatientNote patientNote1 = noteService.getNoteByNoteId("1");
        assertTrue(patientNote1 != null);
    }

    @Test
    void patientNoteGetByNoteId_NotFound() {
        List<PatientNote> patientNotes = new ArrayList<>();
        Mockito.when(noteRepository.findPatientNoteByNoteId("1")).thenReturn(patientNotes);
        try {
            PatientNote patientNote = noteService.getNoteByNoteId("1");
        } catch (Exception e) {
            assertTrue(e.toString().contains("note not found for noteId"));
        }


    }

    @Test
    void patientNoteGetByPatientId() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);

        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("patientId").is(1));

        Mockito.when(mongoOperations.find(searchQuery, PatientNote.class)).thenReturn(patientNotes);
        List<PatientNote> listPatientNotes = noteService.getNoteByPatientId(1);
        assertTrue(listPatientNotes.size() > 0);
    }

    @Test
    void addPatientNoteTest() {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        long seqValue = 1;
        Mockito.when(sequenceGeneratorService.generateSequence(PatientNote.SEQUENCE_NAME)).thenReturn(seqValue);
        Mockito.when(noteRepository.save(patientNote)).thenReturn(patientNote);
        String result = noteService.addNote(patientNote).getNoteId();
        assertTrue(result.equals("1"));
    }

    @Test
    void deletePatientNoteTest() {
        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("noteId").is("1"));
        Mockito.when(mongoOperations.remove(searchQuery, PatientNote.class)).thenReturn(DeleteResult.acknowledged(1));
        Boolean result = noteService.deleteNoteByNoteId("1");
        assertTrue(result == true);
    }

    @Test
    void updatePatientNoteTest() {
        LocalDateTime dtUpdate = LocalDateTime.now();
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("new title");
        patientNote.setNote("new note");
        patientNote.setUpdateDate(dtUpdate);
        Query query = new Query();
        query.addCriteria(Criteria.where("noteId").is("1"));
        Mockito.when(mongoOperations.findOne(query, PatientNote.class)).thenReturn(patientNote);
        Update update = new Update();
        update.set("title", "new title");
        update.set("note", "new note");
        update.set("updateDate", dtUpdate.toString());
        long mockResult = 1;
        BsonObjectId bsonObjectId = new BsonObjectId(new ObjectId("5ff72f561de2b76348ef1804"));
        Mockito.when(mongoOperations.updateFirst(query, update, PatientNote.class)).thenReturn(UpdateResult.acknowledged(mockResult, mockResult, bsonObjectId));
        Boolean result = noteService.updateNote(patientNote);
        assertTrue(result == true);
    }

}
