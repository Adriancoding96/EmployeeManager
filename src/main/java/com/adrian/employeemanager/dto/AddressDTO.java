package com.adrian.employeemanager.dto;

import java.time.LocalDateTime;

public class AddressDTO {

    private Long addressId;
    private String city;
    private String postalCode;
    private String streetName;
    private Integer apartmentFloor;
    private Integer apartmentNumber;


    public AddressDTO() {
    }

    public AddressDTO(Long addressId, String city, String postalCode, String streetName, Integer apartmentFloor, Integer apartmentNumber) {
        this.addressId = addressId;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.apartmentFloor = apartmentFloor;
        this.apartmentNumber = apartmentNumber;
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", apartmentFloor=" + apartmentFloor +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
