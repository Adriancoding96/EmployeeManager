package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.NoteDTO;
import com.adrian.employeemanager.model.Note;

import java.util.List;

public interface NoteService {

   Note createNote(NoteDTO noteDTO);
   List<Note> getAllNotes();
}
