package com.adrian.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", nullable = true)
    @JsonManagedReference
    private Evaluation evaluation;

    @Column(nullable = false)
    private String noteTitle;

    @Column(nullable = false)
    private String noteText;

    @Column(nullable = false)
    private LocalDate created;

    @Column(nullable = false)
    private LocalDate modified;

    @PrePersist
    @PreUpdate
    private void validate(){
        if(employee == null && evaluation == null){
            throw new IllegalStateException("Both employee and interaction cannot be null");
        }
        if(employee != null && evaluation != null){
            throw new IllegalStateException("Both employee and interaction cannot be non-null simultaneously");
        }
    }

    public Note() {
    }

    public Long getNoteId() {
        return noteId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Evaluation getInteraction() {
        return evaluation;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setInteraction(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
