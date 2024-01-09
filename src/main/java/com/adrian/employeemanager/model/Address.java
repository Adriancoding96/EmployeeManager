package com.adrian.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = true)
    private Integer apartmentFloor;

    @Column(nullable = false)
    private Integer apartmentNumber;

    @OneToMany(mappedBy = "address")
    @Column(nullable = true)
    private List<Employee> employees;

    @OneToMany(mappedBy = "address")
    private List<Department> departments;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Address() {
    }

    public Address(Long addressId, String city, String postalCode, String streetName, Integer apartmentFloor, Integer apartmentNumber, List<Employee> employees, List<Department> departments, LocalDateTime created, LocalDateTime modified) {
        this.addressId = addressId;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.apartmentFloor = apartmentFloor;
        this.apartmentNumber = apartmentNumber;
        this.employees = employees;
        this.departments = departments;
        this.created = created;
        this.modified = modified;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getApartmentFloor() {
        return apartmentFloor;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setApartmentFloor(Integer apartmentFloor) {
        this.apartmentFloor = apartmentFloor;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
