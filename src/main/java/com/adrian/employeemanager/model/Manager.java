package com.adrian.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "manager")
    @Column(nullable = false)
    private List<Evaluation> evaluations;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Manager() {
    }

    public Manager(Long managerId, User user, Department department, List<Evaluation> evaluations, LocalDateTime created, LocalDateTime modified) {
        this.managerId = managerId;
        this.user = user;
        this.department = department;
        this.evaluations = evaluations;
        this.created = created;
        this.modified = modified;
    }

    public Long getManagerId() {
        return managerId;
    }

    public User getUser() {
        return user;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Evaluation> getEvalutations() {
        return evaluations;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEvalutations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
