package com.ocr.p9_note.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.service.NoteService;
import com.ocr.p9_note.service.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientNoteControllerTest {

    @MockBean
    private NoteService noteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeShouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllNotesShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);
        Mockito.when(noteService.getAllNotes()).thenReturn(patientNotes);

        this.mockMvc.perform(get("/notes")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getNotesByNoteIdShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);
        Mockito.when(noteService.getNoteByNoteId("1")).thenReturn(patientNotes);

        this.mockMvc.perform(get("/notes/1")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getNotesByPatientIdShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        List<PatientNote> patientNotes = new ArrayList<>();
        patientNotes.add(patientNote);
        Mockito.when(noteService.getNoteByPatientId(1)).thenReturn(patientNotes);

        this.mockMvc.perform(get("/notes/patient/1")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void postNoteShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patientNote);
        //
        this.mockMvc.perform(post("/notes").contentType(MediaType.APPLICATION_JSON).content(patientJSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void postNoteShouldReturn_KO() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("");
        patientNote.setNote("test de note");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patientNote);
        //
        this.mockMvc.perform(post("/notes").contentType(MediaType.APPLICATION_JSON).content(patientJSON))
                .andDo(print()).andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    void putPersonShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patientNote);
        //
        this.mockMvc.perform(put("/notes").contentType(MediaType.APPLICATION_JSON).content(patientJSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void deleteNoteShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setNoteId("1");
        patientNote.setPatientId(1);
        patientNote.setTitle("test");
        patientNote.setNote("test de note");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patientNote);
        //
        this.mockMvc.perform(delete("/notes/1")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
