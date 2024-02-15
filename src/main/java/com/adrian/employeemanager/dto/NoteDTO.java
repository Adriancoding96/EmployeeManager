package com.adrian.employeemanager.dto;

public class NoteDTO {

    private Long noteId;
    private Long employeeId;
    private String noteTitle;
    private String noteText;


    public NoteDTO() {
    }


    public NoteDTO(Long noteId, Long employeeId, String noteTitle, String noteText) {
        this.noteId = noteId;
        this.employeeId = employeeId;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    public Long getNoteId() {
        return noteId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
