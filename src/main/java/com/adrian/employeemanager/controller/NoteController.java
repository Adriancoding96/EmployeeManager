package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.NoteDTO;
import com.adrian.employeemanager.model.Note;
import com.adrian.employeemanager.service.interfaces.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/note")
public class NoteController{

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping
    public ResponseEntity<Note> createEntity(@RequestBody NoteDTO noteDTO) {
        Note createdNote = noteService.createNote(noteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }


    public ResponseEntity<Note> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<Note> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }


    public ResponseEntity<List<Note>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<Note> updateEntity(Long aLong, Note entity) {
        return null;
    }


    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
