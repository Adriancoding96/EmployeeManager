INSERT INTO users (username, password, role, created, modified) VALUES
                                                                    ('user1', 'password1', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user2', 'password2', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user3', 'password3', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user4', 'password4', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user5', 'password5', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user6', 'password6', 'MANAGER', NOW(), NOW()),
                                                                    ('user7', 'password7', 'MANAGER', NOW(), NOW()),
                                                                    ('user8', 'password8', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user9', 'password9', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user10', 'password10', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user11', 'password11', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user12', 'password12', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user13', 'password13', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user14', 'password14', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user15', 'password15', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user16', 'password16', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user17', 'password17', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user18', 'password18', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user19', 'password19', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user20', 'password20', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user21', 'password21', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user22', 'password22', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user23', 'password23', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user24', 'password24', 'EMPLOYEE', NOW(), NOW()),
                                                                    ('user25', 'password25', 'EMPLOYEE', NOW(), NOW());



INSERT INTO addresses (city, postal_code, street_name, apartment_floor, apartment_number, created, modified) VALUES
                                                                                                                 ('Stockholm', 'Postal1', 'Street1', 1, 101, NOW(), NOW()),
                                                                                                                 ('Malmö', 'Postal2', 'Street2', 2, 102, NOW(), NOW()),
                                                                                                                 ('London', 'Postal3', 'Street3', 3, 103, NOW(), NOW()),
                                                                                                                 ('Nottingham', 'Postal4', 'Street4', 4, 104, NOW(), NOW()),
                                                                                                                 ('Dublin', 'Postal5', 'Street5', 5, 105, NOW(), NOW());


INSERT INTO departments (department_name, address_id, created, modified) VALUES
                                                                             ('Teamify Stockholm', 1, NOW(), NOW()),
                                                                             ('Teamify Malmö', 2, NOW(), NOW()),
                                                                             ('Teamify London', 3, NOW(), NOW()),
                                                                             ('Teamify Nottingham', 4, NOW(), NOW()),
                                                                             ('Teamify Dublin', 5, NOW(), NOW());


INSERT INTO employees (user_id, name, email, phone_number, position, address_id, department_id, created, modified) VALUES
                                                                                                                       (1, 'Adrian Nilsson', 'adrian.nilsson@example.com', '+46-0000001', 'Junior_Developer', 1, 1, NOW(), NOW()),
                                                                                                                       (2, 'Erik Svensson', 'erik.svensson@example.com', '0000000002', 'Senior_Developer', 2, 2, NOW(), NOW()),
                                                                                                                       (3, 'Liam Murphy', 'liam.murphy@example.com', '0000000003', 'Tech_Lead', 3, 3, NOW(), NOW()),
                                                                                                                       (4, 'Alice Connor', 'alice.oconnor@example.com', '0000000004', 'Junior_Developer', 4, 4, NOW(), NOW()),
                                                                                                                        (5, 'Sofia Johansson', 'sofia.johansson@example.com', '0000000005', 'Senior_Developer', 5, 5, NOW(), NOW()),
                                                                                                                        (6, 'James Smith', 'james.smith@example.com', '0000000006', 'Junior_Developer', 1, 1, NOW(), NOW()),
                                                                                                                        (7, 'Ella Ryan', 'ella.ryan@example.com', '0000000007', 'Tech_Lead', 2, 2, NOW(), NOW()),
                                                                                                                        (8, 'Oscar Lundberg', 'oscar.lundberg@example.com', '0000000008', 'Senior_Developer', 3, 3, NOW(), NOW()),
                                                                                                                        (9, 'Emily Walsh', 'emily.walsh@example.com', '0000000009', 'Junior_Developer', 4, 4, NOW(), NOW()),
                                                                                                                        (10, 'William Karlsson', 'william.karlsson@example.com', '0000000010', 'Tech_Lead', 5, 5, NOW(), NOW()),
                                                                                                                        (11, 'Nora Byrne', 'nora.byrne@example.com', '0000000011', 'Senior_Developer', 1, 1, NOW(), NOW()),
                                                                                                                        (12, 'Lucas Gustafsson', 'lucas.gustafsson@example.com', '0000000012', 'Junior_Developer', 2, 2, NOW(), NOW()),
                                                                                                                        (13, 'Emma Doyle', 'emma.doyle@example.com', '0000000013', 'Tech_Lead', 3, 3, NOW(), NOW()),
                                                                                                                        (14, 'Alexander Lindberg', 'alexander.lindberg@example.com', '0000000014', 'Senior_Developer', 4, 4, NOW(), NOW()),
                                                                                                                        (15, 'Mia Sullivan', 'mia.osullivan@example.com', '0000000015', 'Junior_Developer', 5, 5, NOW(), NOW()),
                                                                                                                         (16, 'Oliver Ekström', 'oliver.ekstrom@example.com', '0000000016', 'Tech_Lead', 1, 1, NOW(), NOW()),
                                                                                                                         (17, 'Isabella McCarthy', 'isabella.mccarthy@example.com', '0000000017', 'Senior_Developer', 2, 2, NOW(), NOW()),
                                                                                                                         (18, 'Elias Andersson', 'elias.andersson@example.com', '0000000018', 'Junior_Developer', 3, 3, NOW(), NOW()),
                                                                                                                        (19, 'Anna Neill', 'anna.oneill@example.com', '0000000019', 'Tech_Lead', 4, 4, NOW(), NOW()),
                                                                                                                        (20, 'Hugo Olsson', 'hugo.olsson@example.com', '0000000020', 'Senior_Developer', 5, 5, NOW(), NOW()),
                                                                                                                        (21, 'Sarah Kelly', 'sarah.kelly@example.com', '0000000021', 'Junior_Developer', 1, 1, NOW(), NOW()),
                                                                                                                        (22, 'Axel Persson', 'axel.persson@example.com', '0000000022', 'Tech_Lead', 2, 2, NOW(), NOW()),
                                                                                                                        (23, 'Grace Doherty', 'grace.doherty@example.com', '0000000023', 'Senior_Developer', 3, 3, NOW(), NOW()),
                                                                                                                        (24, 'Viktor Berg', 'viktor.berg@example.com', '0000000024', 'Junior_Developer', 4, 4, NOW(), NOW()),
                                                                                                                        (25, 'Charlotte Gallagher', 'charlotte.gallagher@example.com', '0000000025', 'Junior_Developer', 4, 4, NOW(), NOW());



INSERT INTO managers (user_id, department_id, created, modified) VALUES
                                                                     (6, 1, NOW(), NOW()),
                                                                     (7, 2, NOW(), NOW());

INSERT INTO certifications (employee_id, name, organization, status, created, modified) VALUES
                                                                                            (1, 'CLoud Development', 'Microsoft', 'ACTIVE', NOW(), NOW()),
                                                                                            (2, 'Embedded Systems Development', 'Udemy', 'ACTIVE', NOW(), NOW()),
                                                                                            (3, 'CS50', 'Fedex', 'ACTIVE', NOW(), NOW()),
                                                                                            (4, 'React Development', 'Udemy', 'ACTIVE', NOW(), NOW()),
                                                                                            (5, 'Outsystems UI/UX Developer', 'Outsystems', 'ACTIVE ', NOW(), NOW());


INSERT INTO educations (employee_id, education_type, degree, start_date, end_date, created, modified) VALUES
                                                                                                          (1, 'MASTERS', 'Computer Science', '2022-01-01', '2024-06-01', NOW(), NOW()),
                                                                                                          (2, 'MASTERS', 'Computer Science', '2016-02-01', '2018-07-01', NOW(), NOW()),
                                                                                                          (2, 'MASTERS', 'Physics', '2024-02-01', '2024-07-01', NOW(), NOW()),
                                                                                                          (3, 'MASTERS', 'Engineering', '2024-03-01', '2024-08-01', NOW(), NOW()),
                                                                                                          (4, 'MASTERS', 'Law', '2024-04-01', '2024-09-01', NOW(), NOW()),
                                                                                                          (5, 'MASTERS', 'Chemistry', '2024-05-01', '2024-10-01', NOW(), NOW());


INSERT INTO evaluations (manager_id, employee_id, date_of_evaluation, created, modified, comment) VALUES
                                                                                                      (1, 1, '2024-01-01', NOW(), NOW(), 'In the past year, Adrian has demonstrated exceptional dedication to their role as a Senior Developer. They have not only met their project deadlines consistently but have also gone above and beyond by contributing innovative solutions to enhance our software''s user experience. Alex''s ability to work collaboratively with cross-functional teams has been instrumental in the successful launch of our flagship product, leading to a 20% increase in customer satisfaction ratings. Their technical expertise, particularly in the realm of cybersecurity, has significantly strengthened our product''s market position. Alex is highly proactive in their approach to professional development, often engaging in self-directed learning and sharing their knowledge with the team through weekly workshops. Moving forward, focusing on leadership skills development could further Alex''s career trajectory within our organization, potentially preparing them for a lead role in upcoming projects'),
                                                                                                      (1, 1, '2024-06-15', NOW(), NOW(), 'Adrian has shown commendable progress in their role as a Marketing Specialist over the first half of the year. They have successfully managed multiple marketing campaigns, demonstrating strong project management skills and an ability to stay organized under pressure. Jordan''s creativity in campaign design has been a breath of fresh air, bringing fresh ideas that align with our brand''s voice and resonate well with our target audience, as evidenced by a 15% increase in engagement on our social media platforms. However, there is an opportunity for improvement in data analysis and interpretation. Enhancing these skills can enable Jordan to derive more insightful conclusions from campaign data, leading to even more effective marketing strategies. Encouraging Jordan to participate in data analytics workshops and seminars could be beneficial. Overall, Jordan''s contributions are highly valued, and with continued growth, they are on track to exceed their performance goals by the year-end.'),
                                                                                                      (1, 1, '2024-12-30', NOW(), NOW(), 'Adrian has exhibited significant development in their position as a Marketing Specialist throughout the initial six months of the year. They have adeptly overseen various marketing initiatives, showcasing impressive organizational skills and a capacity to maintain composure in stressful situations. Jordan''s innovative approach to campaign creation has injected new life into our strategies, introducing concepts that harmonize with our brand''s identity and effectively engage our desired demographic, as demonstrated by a 15%'),
                                                                                                      (1, 3, '2024-01-01', NOW(), NOW(), 'Comment 3'),
                                                                                                      (1, 3, '2024-01-15', NOW(), NOW(), 'Comment 4'),
                                                                                                      (1, 3, '2024-01-30', NOW(), NOW(), 'Comment 5'),
                                                                                                      (1, 4, '2024-02-01', NOW(), NOW(), 'Comment 6'),
                                                                                                      (2, 4, '2024-02-01', NOW(), NOW(), 'Comment 9'),
                                                                                                      (1, 5, '2024-12-30', NOW(), NOW(), 'Comment 7'),
                                                                                                      (1, 5, '2024-02-15', NOW(), NOW(), 'Comment 8');


INSERT INTO past_employment (employee_id, information, created, modified) VALUES
                                                                                        (1, 'Spotify', NOW(), NOW()),
                                                                                        (2, 'Facebook', NOW(), NOW()),
                                                                                        (3, 'Microsoft', NOW(), NOW()),
                                                                                        (4, 'Amazon', NOW(), NOW()),
                                                                                        (5, 'Netflix', NOW(), NOW());

INSERT INTO emergency_contacts (employee_id, name, email, phone_number, address_id, created, modified) VALUES
                                                                                                           (1, 'Christian Nilsson', 'christian.nilsson@example.com', '+46702569981', 1, NOW(), NOW()),
                                                                                                           (1, 'Connie Martin', 'connie.martin@example.com', '+447595068441', 2, NOW(), NOW()),
                                                                                                           (3, 'Pelle Svensson', 'pelle.svensson@example.com', '1000000003', 3, NOW(), NOW()),
                                                                                                           (4, 'Kalle karlsson', 'kalle.karlson@example.com', '1000000004', 4, NOW(), NOW()),
                                                                                                           (5, 'James smith', 'james.smith@example.com', '1000000005', 5, NOW(), NOW());

INSERT INTO notes (employee_id, interaction_id, note_title, note_text, created, modified) VALUES
                                                                                              (1, 1, 'Time off', 'Time off requested in march for a trip to the UK', '2024-01-01', '2024-01-02'),
                                                                                              (2, 2, 'New Project', 'Being placed in a new project in june of 2024', '2024-02-01', '2024-02-02'),
                                                                                              (3, 3, 'Parental leave', 'Parental leave planned for beginning of 2025', '2024-03-01', '2024-03-02'),
                                                                                              (4, 4, 'Extended summer vacation', 'Employee has requested extended vacation for travel to the us', '2024-04-01', '2024-04-02'),
                                                                                              (5, 5, 'Cant attend friday scrums in march', 'Due to working on another important project employee is unable to attend our weekly friday meeting', '2024-05-01', '2024-05-02');


