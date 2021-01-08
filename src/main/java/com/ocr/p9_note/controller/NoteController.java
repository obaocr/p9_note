package com.ocr.p9_note.controller;

import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/notes")
    public List<PatientNote> getAllNotes() {
        logger.debug("P9 get All Notes");
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/patient/{patientId}")
    public List<PatientNote> getNoteByPatientId(@PathVariable Integer patientId) {
        logger.debug("P9 get Note by Patient Id" + patientId);
        return noteService.getNoteByPatientId(patientId);
    }

    @GetMapping("/notes/{noteId}")
    public List<PatientNote> getNoteByNoteId(@PathVariable("noteId") Long noteId) {
        logger.debug("P9 get Note by Note Id" + noteId);
        return noteService.getNoteByNoteId(noteId);
    }

    @PostMapping("/notes")
    public Long addNote(@RequestBody @Valid PatientNote note) {
        logger.debug("P9 add note :" + note.toString());
        return noteService.addNote(note);
    }

    @PutMapping("/notes")
    public Boolean updateNote(@RequestBody @Valid PatientNote note) {
        logger.debug("P9 update note :" + note.toString());
        return noteService.updateNote(note);
    }

    @DeleteMapping("/notes/{Id}")
    public Boolean deleteNoteByNoteId(@PathVariable("Id") Long Id) {
        logger.debug("P9 delete Note by Note Id" + Id);
        noteService.deleteNoteByNoteId(Id);
        return true;
    }

}
