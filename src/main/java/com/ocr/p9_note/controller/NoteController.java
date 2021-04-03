package com.ocr.p9_note.controller;

import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.service.NoteService;
import com.ocr.p9_note.utils.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Controller for notes
 */
@RestController
public class NoteController {

    private Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String noteHome() {
        logger.debug("P9 Note Home");
        return "P9 Note Home";
    }

    @GetMapping("/notes/patient/{patientId}")
    public List<PatientNote> getNotesByPatientId(@PathVariable Integer patientId) {
        logger.debug("P9 get searchNote by Patient Id" + patientId);
        if (Objects.isNull(patientId)) {
            return noteService.getAllNotes();
        }
        return noteService.getNoteByPatientId(patientId);
    }

    @GetMapping("/notes")
    public List<PatientNote> getNoteSearchPatientId(@RequestParam(required = false) Integer patientId) {
        logger.debug("P9 get searchNote by Patient Id" + patientId);
        if (Objects.isNull(patientId)) {
            return noteService.getAllNotes();
        }
        return noteService.getNoteByPatientId(patientId);
    }

    @GetMapping("/notes/{noteId}")
    public PatientNote getNoteByNoteId(@PathVariable("noteId") String noteId) {
        logger.debug("P9 get Note by Note Id" + noteId);
        return noteService.getNoteByNoteId(noteId);
    }

    @PostMapping("/notes")
    public PatientNote addNote(@RequestBody PatientNote note) {
        logger.debug("P9 add note :" + note.toString());
        Check.checkNote(note);
        return noteService.addNote(note);
    }

    @PutMapping("/notes")
    public Boolean updateNote(@RequestBody PatientNote note) {
        logger.debug("P9 update note :" + note.toString());
        Check.checkNote(note);
        return noteService.updateNote(note);
    }

    @DeleteMapping("/notes/{Id}")
    public Boolean deleteNoteByNoteId(@PathVariable("Id") String Id) {
        logger.debug("P9 delete Note by Note Id" + Id);
        noteService.deleteNoteByNoteId(Id);
        return true;
    }

}
