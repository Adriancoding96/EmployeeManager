package com.adrian.employeemanager.model;

import com.adrian.employeemanager.enums.PositionEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PositionEnum position;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "employee")
    private List<PastEmployment> employmentHistory;

    @OneToMany(mappedBy = "employee")
    private List<Education> educations;

    @OneToMany(mappedBy = "employee")
    private List<EmergencyContact> ice;

    @OneToMany(mappedBy = "employee")
    private List<Note> notes;

    @OneToMany(mappedBy = "employee")
    private List<Certification> certifications;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Employee(){

    }

    public Employee(Long employeeId, User user, String name, String email, String phoneNumber, PositionEnum position, Address address, Department department, List<Evaluation> evaluations, List<PastEmployment> employmentHistory, List<Education> educations, List<EmergencyContact> ice, List<Note> notes, List<Certification> certifications, LocalDateTime created, LocalDateTime modified) {
        this.employeeId = employeeId;
        this.user = user;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.address = address;
        this.department = department;
        this.evaluations = evaluations;
        this.employmentHistory = employmentHistory;
        this.educations = educations;
        this.ice = ice;
        this.notes = notes;
        this.certifications = certifications;
        this.created = created;
        this.modified = modified;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public List<PastEmployment> getEmploymentHistory() {
        return employmentHistory;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<EmergencyContact> getIce() {
        return ice;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void setEmploymentHistory(List<PastEmployment> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public void setIce(List<EmergencyContact> ice) {
        this.ice = ice;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
