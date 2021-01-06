package com.ocr.p9_note.controller;

import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/Notes")
    public List<PatientNote> getAllNotes() {
        logger.debug("P9 get All Notes");
        return noteService.getAllNotes();
    }

    @GetMapping("/Note")
    public List<PatientNote> getNoteByPatientId(@RequestParam Integer patientId) {
        logger.debug("P9 get Note by Note Id" + patientId);
        return noteService.getNoteByPatientId(patientId);
    }

    @PostMapping("/Note")
    public String addNote(PatientNote note) {
        logger.debug("P9 add note");
        return noteService.addNote(note);
    }

}
