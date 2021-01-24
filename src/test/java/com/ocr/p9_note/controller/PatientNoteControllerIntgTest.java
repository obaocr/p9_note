package com.ocr.p9_note.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocr.p9_note.model.PatientNote;
import com.ocr.p9_note.service.NoteService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientNoteControllerIntgTest {

    @Autowired
    private NoteService noteService;

    @Autowired
    private MockMvc mockMvc;

    @Disabled
    @Test
    void postNoteShouldReturnOK() throws Exception {
        PatientNote patientNote = new PatientNote();
        patientNote.setPatientId(1);
        patientNote.setTitle("Title note test from ctrl");
        patientNote.setNote("Note test from ctrl");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patientNote);
        //
        this.mockMvc.perform(post("/notes").contentType(MediaType.APPLICATION_JSON).content(patientJSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

}
