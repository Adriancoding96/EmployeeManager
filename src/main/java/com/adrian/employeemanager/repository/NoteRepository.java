package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository  extends JpaRepository<Note, Long> {
}
