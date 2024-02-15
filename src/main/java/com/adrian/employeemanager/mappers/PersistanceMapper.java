package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.*;
import com.adrian.employeemanager.model.*;
import com.adrian.employeemanager.service.interfaces.AddressService;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PersistanceMapper {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    @Autowired
    public PersistanceMapper(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    public Department DTOToDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        if(departmentDTO.getDepartmentId() != null){
            department.setDepartmentId(departmentDTO.getDepartmentId());
        }

        Address address = new Address();
        address.setCity(departmentDTO.getAddressDTO().getCity());
        address.setPostalCode(departmentDTO.getAddressDTO().getPostalCode());
        address.setStreetName(departmentDTO.getAddressDTO().getStreetName());
        address.setApartmentNumber(departmentDTO.getAddressDTO().getApartmentNumber());
        address.setApartmentFloor(departmentDTO.getAddressDTO().getApartmentFloor());
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        addressService.createAddress(address);
        department.setAddress(address);
        department.setDepartmentName(departmentDTO.getDepartmentName());
        return department;
    }

    public Certification DTOToCertification(CertificationDTO certificationDTO){
        Certification certification = new Certification();
        if(certificationDTO.getCertificationId() != null){
            certification.setCertificationId(certificationDTO.getCertificationId());
        }

        Employee employee = employeeService.getEmployeeById(certificationDTO.getEmployeeId());
        certification.setEmployee(employee);
        certification.setName(certificationDTO.getName());
        certification.setStatus(certificationDTO.getStatus());
        certification.setOrganization(certificationDTO.getOrganization());
        return certification;
    }

    public PastEmployment DTOToPastEmployment(PastEmploymentDTO pastEmploymentDTO){
        PastEmployment pastEmployment = new PastEmployment();
        if(pastEmploymentDTO.getPastemploymentId() != null){
            pastEmployment.setEmploymentHistoryId(pastEmploymentDTO.getPastemploymentId());
        }

        Employee employee = employeeService.getEmployeeById(pastEmploymentDTO.getEmployeeId());
        pastEmployment.setEmployee(employee);
        pastEmployment.setInformation(pastEmploymentDTO.getInformation());
        return pastEmployment;
    }

    public Note DTOtoNote(NoteDTO noteDTO){
        Note note = new Note();
        if(noteDTO.getNoteId() != null){
            note.setNoteId(noteDTO.getNoteId());
        }

        Employee employee = employeeService.getEmployeeById(noteDTO.getEmployeeId());
        note.setEmployee(employee);
        note.setNoteTitle(noteDTO.getNoteTitle());
        note.setNoteText(noteDTO.getNoteText());
        return note;
    }

    public EmergencyContact DTOtoEmergencyContact(EmergencyContactDTO emergencyContactDTO){
        EmergencyContact emergencyContact = new EmergencyContact();
        if(emergencyContactDTO.getEmergencyContactId() != null){
           emergencyContact.setEmergencyContactId(emergencyContactDTO.getEmergencyContactId());
        }

        Employee employee = employeeService.getEmployeeById(emergencyContactDTO.getEmployeeId());
        emergencyContact.setEmployee(employee);

        Address address = new Address();
        address.setCity(emergencyContactDTO.getAddressDTO().getCity());
        address.setStreetName(emergencyContactDTO.getAddressDTO().getStreetName());
        address.setPostalCode(emergencyContactDTO.getAddressDTO().getPostalCode());
        address.setApartmentFloor(emergencyContactDTO.getAddressDTO().getApartmentFloor());
        address.setApartmentNumber(emergencyContactDTO.getAddressDTO().getApartmentNumber());
        addressService.createAddress(address);
        emergencyContact.setAddress(address);

        emergencyContact.setName(emergencyContactDTO.getName());
        emergencyContact.setEmail(emergencyContactDTO.getEmail());
        emergencyContact.setPhoneNumber(emergencyContactDTO.getPhoneNumber());
        return emergencyContact;
    }


}
