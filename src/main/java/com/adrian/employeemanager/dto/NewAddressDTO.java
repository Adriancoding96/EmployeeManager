package com.adrian.employeemanager.dto;

public class NewAddressDTO {

    private String city;
    private String postalCode;
    private String streetName;
    private Integer apartmentFloor;
    private Integer apartmentNumber;

    public NewAddressDTO() {
    }

    public NewAddressDTO(String city, String postalCode, String streetName, Integer apartmentFloor, Integer apartmentNumber) {
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.apartmentFloor = apartmentFloor;
        this.apartmentNumber = apartmentNumber;
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
}
