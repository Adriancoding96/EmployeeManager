INSERT INTO users (username, password, role, created, modified) VALUES
                                                                    ('user1', 'password1', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user2', 'password2', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user3', 'password3', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user4', 'password4', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user5', 'password5', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user6', 'password6', 'MANAGER', NOW(), NOW()),
                                                                    ('user7', 'password7', 'MANAGER', NOW(), NOW());

INSERT INTO addresses (city, postal_code, street_name, apartment_floor, apartment_number, created, modified) VALUES
                                                                                                                 ('City1', 'Postal1', 'Street1', 1, 101, NOW(), NOW()),
                                                                                                                 ('City2', 'Postal2', 'Street2', 2, 102, NOW(), NOW()),
                                                                                                                 ('City3', 'Postal3', 'Street3', 3, 103, NOW(), NOW()),
                                                                                                                 ('City4', 'Postal4', 'Street4', 4, 104, NOW(), NOW()),
                                                                                                                 ('City5', 'Postal5', 'Street5', 5, 105, NOW(), NOW());


INSERT INTO departments (department_name, address_id, created, modified) VALUES
                                                                             ('Department1', 1, NOW(), NOW()),
                                                                             ('Department2', 2, NOW(), NOW()),
                                                                             ('Department3', 3, NOW(), NOW()),
                                                                             ('Department4', 4, NOW(), NOW()),
                                                                             ('Department5', 5, NOW(), NOW());


INSERT INTO employees (user_id, name, email, phone_number, position, address_id, department_id, created, modified) VALUES
                                                                                                                       (1, 'Employee1', 'email1@example.com', '0000000001', 'Position1', 1, 1, NOW(), NOW()),
                                                                                                                       (2, 'Employee2', 'email2@example.com', '0000000002', 'Position2', 2, 2, NOW(), NOW()),
                                                                                                                       (3, 'Employee3', 'email3@example.com', '0000000003', 'Position3', 3, 3, NOW(), NOW()),
                                                                                                                       (4, 'Employee4', 'email4@example.com', '0000000004', 'Position4', 4, 4, NOW(), NOW()),
                                                                                                                       (5, 'Employee5', 'email5@example.com', '0000000005', 'Position5', 5, 5, NOW(), NOW());


INSERT INTO managers (user_id, department_id, created, modified) VALUES
                                                                     (6, 1, NOW(), NOW()),
                                                                     (7, 2, NOW(), NOW());

INSERT INTO certifications (employee_id, name, organization, status, created, modified) VALUES
                                                                                            (1, 'Certification1', 'Organization1', 'Active', NOW(), NOW()),
                                                                                            (2, 'Certification2', 'Organization2', 'Active', NOW(), NOW()),
                                                                                            (3, 'Certification3', 'Organization3', 'Inactive', NOW(), NOW()),
                                                                                            (4, 'Certification4', 'Organization4', 'Active', NOW(), NOW()),
                                                                                            (5, 'Certification5', 'Organization5', 'Inactive', NOW(), NOW());


INSERT INTO educations (employee_id, education_type, degree, start_date, created, modified) VALUES
                                                                                                (1, 'Type1', 'Degree1', '2024-01-01', NOW(), NOW()),
                                                                                                (2, 'Type2', 'Degree2', '2024-02-01', NOW(), NOW()),
                                                                                                (3, 'Type3', 'Degree3', '2024-03-01', NOW(), NOW()),
                                                                                                (4, 'Type4', 'Degree4', '2024-04-01', NOW(), NOW()),
                                                                                                (5, 'Type5', 'Degree5', '2024-05-01', NOW(), NOW());

INSERT INTO evaluations (manager_id, employee_id, date_of_evaluation, created, modified) VALUES
                                                                                             (1, 1, '2024-01-15', NOW(), NOW()),
                                                                                             (1, 2, '2024-01-20', NOW(), NOW()),
                                                                                             (2, 3, '2024-01-25', NOW(), NOW()),
                                                                                             (2, 4, '2024-02-01', NOW(), NOW()),
                                                                                             (1, 5, '2024-02-05', NOW(), NOW());

INSERT INTO past_employment (employee_id, information, end_date, created, modified) VALUES
                                                                                        (1, 'Info about past employment 1', '2023-12-31', NOW(), NOW()),
                                                                                        (2, 'Info about past employment 2', '2023-12-31', NOW(), NOW()),
                                                                                        (3, 'Info about past employment 3', '2023-11-30', NOW(), NOW()),
                                                                                        (4, 'Info about past employment 4', '2023-10-31', NOW(), NOW()),
                                                                                        (5, 'Info about past employment 5', '2023-09-30', NOW(), NOW());

INSERT INTO emergency_contacts (employee_id, name, email, phone_number, address_id, created, modified) VALUES
                                                                                                           (1, 'Contact1', 'contact1@example.com', '1000000001', 1, NOW(), NOW()),
                                                                                                           (2, 'Contact2', 'contact2@example.com', '1000000002', 2, NOW(), NOW()),
                                                                                                           (3, 'Contact3', 'contact3@example.com', '1000000003', 3, NOW(), NOW()),
                                                                                                           (4, 'Contact4', 'contact4@example.com', '1000000004', 4, NOW(), NOW()),
                                                                                                           (5, 'Contact5', 'contact5@example.com', '1000000005', 5, NOW(), NOW());

INSERT INTO notes (employee_id, interaction_id, note_title, note_text, created, modified) VALUES
                                                                                              (1, 1, 'Note Title 1', 'Note text 1', '2024-01-01', '2024-01-02'),
                                                                                              (2, 2, 'Note Title 2', 'Note text 2', '2024-02-01', '2024-02-02'),
                                                                                              (3, 3, 'Note Title 3', 'Note text 3', '2024-03-01', '2024-03-02'),
                                                                                              (4, 4, 'Note Title 4', 'Note text 4', '2024-04-01', '2024-04-02'),
                                                                                              (5, 5, 'Note Title 5', 'Note text 5', '2024-05-01', '2024-05-02');


