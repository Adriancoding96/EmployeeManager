
CREATE TABLE users (
                    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    username VARCHAR(30) NOT NULL UNIQUE,
                    password VARCHAR(30) NOT NULL UNIQUE,
                    role VARCHAR(40) NOT NULL,
                    created TIMESTAMP NOT NULL,
                    modified TIMESTAMP NOT NULL
);

CREATE TABLE addresses (
                        address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        city VARCHAR(255) NOT NULL,
                        postal_code VARCHAR(255) NOT NULL,
                        street_name VARCHAR(255) NOT NULL,
                        apartment_floor INT,
                        apartment_number INT NOT NULL,
                        created TIMESTAMP NOT NULL,
                        modified TIMESTAMP NOT NULL
);

CREATE TABLE departments (
                        department_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        department_name VARCHAR(40) NOT NULL,
                        address_id BIGINT NOT NULL,
                        created TIMESTAMP NOT NULL,
                        modified TIMESTAMP NOT NULL,
                        FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

CREATE TABLE employees (
                           employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           user_id BIGINT NOT NULL,
                           name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           phone_number VARCHAR(255) NOT NULL UNIQUE,
                           position VARCHAR(255) NOT NULL,
                           address_id BIGINT NOT NULL,
                           department_id BIGINT NOT NULL,
                           created TIMESTAMP NOT NULL,
                           modified TIMESTAMP NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES users(user_id),
                           FOREIGN KEY (address_id) REFERENCES addresses(address_id),
                           FOREIGN KEY (department_id) REFERENCES departments(department_id)
);


CREATE TABLE managers (
                          manager_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          user_id BIGINT NOT NULL,
                          department_id BIGINT NOT NULL,
                          created TIMESTAMP NOT NULL,
                          modified TIMESTAMP NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users(user_id),
                          FOREIGN KEY (department_id) REFERENCES departments(department_id)
);


CREATE TABLE certifications (
                                certification_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                employee_id BIGINT NOT NULL,
                                name VARCHAR(255) NOT NULL,
                                organization VARCHAR(255) NOT NULL,
                                status VARCHAR(255) NOT NULL,
                                created TIMESTAMP NOT NULL,
                                modified TIMESTAMP NOT NULL,
                                FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);





CREATE TABLE educations (
                        education_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        employee_id BIGINT,
                        education_type VARCHAR(60) NOT NULL,
                        degree VARCHAR(60) NOT NULL,
                        start_date DATE NOT NULL,
                        created TIMESTAMP NOT NULL,
                        modified TIMESTAMP NOT NULL,
                        FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);


CREATE TABLE evaluations (
                             evaluation_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             manager_id BIGINT NOT NULL,
                             employee_id BIGINT NOT NULL,
                             date_of_evaluation DATE NOT NULL,
                             created TIMESTAMP NOT NULL,
                             modified TIMESTAMP NOT NULL,
                             FOREIGN KEY (manager_id) REFERENCES managers(manager_id),
                             FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);


CREATE TABLE past_employment (
                            employment_history_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            employee_id BIGINT,
                            information TEXT NOT NULL,
                            end_date DATE NOT NULL,
                            created TIMESTAMP NOT NULL,
                            modified TIMESTAMP NOT NULL,
                            FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE emergency_contacts (
                                emergency_contact_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                employee_id BIGINT NOT NULL,
                                name VARCHAR(60) NOT NULL,
                                email VARCHAR(40) NOT NULL UNIQUE,
                                phone_number VARCHAR(16) NOT NULL UNIQUE,
                                address_id BIGINT NOT NULL,
                                created TIMESTAMP NOT NULL,
                                modified TIMESTAMP NOT NULL,
                                FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
                                FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);


CREATE TABLE notes (
                       note_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       employee_id BIGINT,
                       interaction_id BIGINT,
                       note_title VARCHAR(255) NOT NULL,
                       note_text TEXT NOT NULL,
                       created DATE NOT NULL,
                       modified DATE NOT NULL,
                       FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);




