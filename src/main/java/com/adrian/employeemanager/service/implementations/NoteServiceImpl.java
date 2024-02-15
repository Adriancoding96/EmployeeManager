package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.NoteDTO;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.Note;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.NoteRepository;
import com.adrian.employeemanager.service.interfaces.NoteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final EmployeeRepository employeeRepository;
    private final PersistanceMapper persistanceMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, EmployeeRepository employeeRepository, PersistanceMapper persistanceMapper) {
        this.noteRepository = noteRepository;
        this.employeeRepository = employeeRepository;
        this.persistanceMapper = persistanceMapper;
    }

    @Override
    public Note createNote(NoteDTO noteDTO) {
        Note note = persistanceMapper.DTOtoNote(noteDTO);
        note.setCreated(LocalDate.now());
        note.setModified(LocalDate.now());
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
