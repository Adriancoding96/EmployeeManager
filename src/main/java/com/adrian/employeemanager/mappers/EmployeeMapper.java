package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.EmployeeDTO;
import com.adrian.employeemanager.dto.EmployeeSelectionDTO;
import com.adrian.employeemanager.dto.NewEmployeeDTO;
import com.adrian.employeemanager.enums.PositionEnum;
import com.adrian.employeemanager.mappers.interfaces.UpdateAction;
import com.adrian.employeemanager.model.*;
import com.adrian.employeemanager.repository.*;
import com.adrian.employeemanager.util.Utils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

private final EmployeeRepository employeeRepository;
private final  AddressRepository addressRepository;
private final DepartmentRepository departmentRepository;
private final EvaluationRepository evaluationRepository;
private final EducationRepository educationRepository;
private final CertificationRepository certificationRepository;
private final PastEmploymentRepository pastEmploymentRepository;
private final EmergencyContactRepository emergencyContactRepository;
private final NoteRepository noteRepository;
private final UserRepository userRepository;
private final Utils utils;


    @Autowired
    public EmployeeMapper(EmployeeRepository employeeRepository, AddressRepository addressRepository, DepartmentRepository departmentRepository, EvaluationRepository evaluationRepository, EducationRepository educationRepository, CertificationRepository certificationRepository, PastEmploymentRepository pastEmploymentRepository, EmergencyContactRepository emergencyContactRepository, NoteRepository noteRepository, UserRepository userRepository, Utils utils) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.departmentRepository = departmentRepository;
        this.evaluationRepository = evaluationRepository;
        this.educationRepository = educationRepository;
        this.certificationRepository = certificationRepository;
        this.pastEmploymentRepository = pastEmploymentRepository;
        this.emergencyContactRepository = emergencyContactRepository;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.utils = utils;
    }

    public EmployeeSelectionDTO toSelectionDTO(Employee employee){
        EmployeeSelectionDTO employeeSelectionDTO = new EmployeeSelectionDTO();
        employeeSelectionDTO.setEmployeeId(employee.getEmployeeId());
        employeeSelectionDTO.setEmployeeName(employee.getName());
        return employeeSelectionDTO;
    }

    public Employee toEmployee(EmployeeDTO employeeDTO, Long id){
        Employee employee;
        if(id!=null){
            employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Employee with id: " + id + " not found!"));
            updateEmployeeRelations(employee, employeeDTO);
            updateEmployeeLists(employee, employeeDTO);
        } else {
            employee = new Employee();
            initializeAndSetRelationsForNewEmployee(employee, employeeDTO);
        }

        updateStaticAttributes(employee, employeeDTO);
        return employee;
    }

    private void initializeAndSetRelationsForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        setAddressForNewEmployee(employee, employeeDTO);
        setDepartmentForNewEmployee(employee, employeeDTO);
        setEvaluationsForNewEmployee(employee, employeeDTO);
        setEducationsForNewEmployee(employee, employeeDTO);
        setCertificatesForNewEmployee(employee, employeeDTO);
        setPastEmploymentsForNewEmployee(employee, employeeDTO);
        setEmergencyContactsForNewEmployee(employee, employeeDTO);
        setNotesForNewEmployee(employee, employeeDTO);
    }


    private void setAddressForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        if(employeeDTO.getAddressId() != null){
            Address address = addressRepository.findById(employeeDTO.getAddressId())
                    .orElseThrow(() -> new EntityNotFoundException("Address with id: " + employeeDTO.getAddressId() + " not found."));
            employee.setAddress(address);
        }
    }

    private void setDepartmentForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        if(employeeDTO.getDepartmentId() != null){
            Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new EntityNotFoundException("Department with id: " + employeeDTO.getAddressId() + " not found."));
            employee.setDepartment(department);
        }
    }

    private void setEvaluationsForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        // Convert the list of evaluation IDs from the DTO to a list of Evaluation objects.
        // This is done by streaming over the IDs, fetching each Evaluation by its ID,
        // and collecting the results into a list.
        List<Evaluation> evaluations = employeeDTO.getEvaluations().stream()
                .map(this::updateEvaluation) //Fetch each evaluation by id
                .collect(Collectors.toList()); //Collect result in to a list
        employee.setEvaluations(evaluations);
    }

    private void setEducationsForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        List<Education> educations = employeeDTO.getEducations().stream()
                .map(this::updateEducation)
                .collect(Collectors.toList());
        employee.setEducations(educations);
    }

    private void setCertificatesForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        List<Certification> certifications = employeeDTO.getCertifications().stream()
                .map(this::updateCertification)
                .collect(Collectors.toList());
        employee.setCertifications(certifications);
    }

    private void setPastEmploymentsForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        List<PastEmployment> pastEmployments = employeeDTO.getPastEmployments().stream()
                .map(this::updatePastEmployment)
                .collect(Collectors.toList());
        employee.setEmploymentHistory(pastEmployments);
    }

    private void setEmergencyContactsForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        List<EmergencyContact> emergencyContacts = employeeDTO.getEmergencyContacts().stream()
                .map(this::updateEmergencyContact)
                .collect(Collectors.toList());
        employee.setIce(emergencyContacts);
    }

    private void setNotesForNewEmployee(Employee employee, EmployeeDTO employeeDTO){
        List<Note> notes = employeeDTO.getNotes().stream()
                .map(this::updateNotes)
                .collect(Collectors.toList());
        employee.setNotes(notes);
    }

    private void updateStaticAttributes(Employee employee, EmployeeDTO employeeDTO){
        employee.setName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmployeeEmail());
        employee.setPhoneNumber(employeeDTO.getEmployeePhone());
        employee.setPosition(employeeDTO.getPosition());
    }

    private void updateEmployeeRelations(Employee employee, EmployeeDTO employeeDTO){
        updateAddressIfNecessary(employee, employeeDTO);
        updateDepartmentIfNecessary(employee, employeeDTO);
    }

    private void updateAddressIfNecessary(Employee employee, EmployeeDTO employeeDTO){
        if(employeeDTO.getAddressId() != null && !employeeDTO.getAddressId().equals(employee.getAddress().getAddressId())){
            employee.setAddress(updateAddress(employeeDTO.getAddressId()));
        }
    }

    private void updateDepartmentIfNecessary(Employee employee, EmployeeDTO employeeDTO){
        if(employeeDTO.getDepartmentId() != null && !employeeDTO.getDepartmentId().equals(employee.getDepartment().getDepartmentId())){
            employee.setDepartment(updateDepartment(employeeDTO.getDepartmentId()));
        }
    }

    private void updateEmployeeLists(Employee employee, EmployeeDTO employeeDTO){
        employee.setEvaluations(updateEvaluations(employee, employeeDTO));
        employee.setEmploymentHistory(updatePastEmployments(employee, employeeDTO));
        employee.setEducations(updateEducations(employee, employeeDTO));
        employee.setCertifications(updateCertifications(employee, employeeDTO));
        employee.setIce(updateEmergencyContacts(employee, employeeDTO));
        employee.setNotes(updateNotes(employee, employeeDTO));
    }

    private List<Evaluation> updateEvaluations(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getEvaluations(), // The existing evaluations of the employee
                employeeDTO.getEvaluations(), // The updated evaluations from the DTO
                Evaluation::getEvaluationId, // Method reference to extract evaluation ID
                this::updateEvaluation // Method reference to the method that updates a single evaluation
        );
    }

    private List<PastEmployment> updatePastEmployments(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getEmploymentHistory(),
                employeeDTO.getPastEmployments(),
                PastEmployment::getEmploymentHistoryId,
                this::updatePastEmployment
        );
    }

    private List<Education> updateEducations(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getEducations(),
                employeeDTO.getEducations(),
                Education::getEducationId,
                this::updateEducation
        );
    }

    private List<Certification> updateCertifications(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getCertifications(),
                employeeDTO.getCertifications(),
                Certification::getCertificationId,
                this::updateCertification
        );
    }

    private List<EmergencyContact> updateEmergencyContacts(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getIce(),
                employeeDTO.getEmergencyContacts(),
                EmergencyContact::getEmergencyContactId,
                this::updateEmergencyContact
        );
    }

    private List<Note> updateNotes(Employee employee, EmployeeDTO employeeDTO){
        return mergeAndApplyUpdates(
                employee.getNotes(),
                employeeDTO.getNotes(),
                Note::getNoteId,
                this::updateNotes
        );
    }

    /**
     * Merges and updates a list of items based on a provided list of updated item IDs.
     * This method is designed to be generic to handle various types of entities.
     *
     * @param <T> The type of the items in the list to be updated.
     * @param <U> The type of the identifier used for the items (e.g., Long for entity IDs).
     * @param existingItems The current list of items associated with an entity.
     * @param newItemIds The list of updated IDs representing the desired state of the items.
     * @param idExtractor A function to extract the ID from an item of type T.
     * @param updateAction An action that defines how to update an item of type T given an ID of type U.
     * @return A list of items of type T, updated according to the provided newItemIds.
     *
     * Usage:
     * This method is used when we have a list of entities (e.g., Employee's evaluations)
     * and a list of updated IDs for these entities. The method will go through the list of IDs,
     * and for each ID, it will either update the existing entity (if it exists and its ID has changed)
     * or add a new entity (if the ID is not present in the existing list).
     *
     * For each ID in the newItemIds list:
     * 1. If the ID is different from the corresponding ID in the existingItems list (based on the index),
     *    an update is performed using the provided updateAction.
     * 2. If the index is within the bounds of the existingItems list and the IDs match, the existing item is retained.
     * 3. If the index is beyond the bounds of the existingItems list, a new item is added using the updateAction.
     *
     * This approach ensures that the existingItems list is effectively updated to match the state represented by newItemIds.
     */
    private <T, U> List<T> mergeAndApplyUpdates(List<T> existingItems, List<U> newItemIds,
                                                Function<T, U> idExtractor, UpdateAction<T, U> updateAction) {
        List<T> updatedItems = new ArrayList<>();
        int k = existingItems.size();
        for(int i = 0, n = newItemIds.size(); i < n; i++){
            if(i < n && !newItemIds.get(i).equals(idExtractor.apply(existingItems.get(i)))) {
                updatedItems.add(updateAction.update(newItemIds.get(i)));
            } else if (i < k){
                updatedItems.add(existingItems.get(i));
            } else {
                updatedItems.add(updateAction.update(newItemIds.get(i)));
            }
        }
        return updatedItems;
    }


    private Address updateAddress(Long newId){
        // Fetch the evaluation by id and return it, or throw an exception if not found
        return addressRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Address with id: " + newId + " not found!"));
    }


    private Department updateDepartment(Long newId){
        return departmentRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Department with id: " + newId + " not found!"));
    }

    private Evaluation updateEvaluation(Long newId){
        return evaluationRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Evaluation with id: " + newId + " not found."));
    }

    private PastEmployment updatePastEmployment(Long newId){
        return pastEmploymentRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("PastEmployment with id: " + newId + " not found."));
    }

    private Education updateEducation(Long newId){
        return educationRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Education with id: " + newId + " not found."));
    }

    private Certification updateCertification(Long newId){
        return certificationRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Certification with id: " + newId + " not found."));
    }

    private EmergencyContact updateEmergencyContact(Long newId){
        return emergencyContactRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("EmergencyContact with id: " + newId + " not found."));
    }

    private Note updateNotes(Long newId){
        return noteRepository.findById(newId)
                .orElseThrow(() -> new EntityNotFoundException("Note with id: " + newId + " not found."));
    }

    public Employee newEmployeFromDTO(NewEmployeeDTO dto) {
        User user = newUser(dto);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        userRepository.save(user);

        Employee employee = new Employee();
        employee.setUser(user);
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setPosition(PositionEnum.valueOf(dto.getPosition()));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department with id: " + dto.getDepartmentId() + " not found."));
        employee.setDepartment(department);

        Address address = new Address();
        address.setCity(dto.getAddress().getCity());
        address.setPostalCode(dto.getAddress().getPostalCode());
        address.setStreetName(dto.getAddress().getStreetName());
        address.setApartmentFloor(dto.getAddress().getApartmentFloor());
        address.setApartmentNumber(dto.getAddress().getApartmentNumber());
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        addressRepository.save(address);
        employee.setAddress(address);

        return employee;
    }

    public User newUser(NewEmployeeDTO dto) {
        String username;
        boolean userNameExists;
        do {
            username = utils.generateRandomUsername();
            userNameExists = userRepository.findUserByUsername(username).isPresent();
        } while (userNameExists);
        String password = utils.generateRandomPassword();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(dto.getRole());

        return user;
    }

}
