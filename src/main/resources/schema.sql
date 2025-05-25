-- Address Table
CREATE TABLE IF NOT EXISTS addresses (
                                         "ID" BIGINT PRIMARY KEY AUTO_INCREMENT,

                                         street VARCHAR(255),
                           city VARCHAR(100),
                           country VARCHAR(100),
                           zip VARCHAR(20),
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP
);

-- PetOwner Table
CREATE TABLE IF NOT EXISTS petowners (
                                         "ID" BIGINT PRIMARY KEY AUTO_INCREMENT,

                                         name VARCHAR(100),
                           email VARCHAR(100),
                           phone VARCHAR(30),
                           address_id BIGINT,
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP,
                           CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES addresses(id)
);

-- Vet Table
CREATE TABLE IF NOT EXISTS vets (
                                    "ID" BIGINT PRIMARY KEY AUTO_INCREMENT,

                                    name VARCHAR(100),
                      specialization VARCHAR(100),
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP
);

-- Pet Table
CREATE TABLE IF NOT EXISTS pets (
                                    "ID" BIGINT PRIMARY KEY AUTO_INCREMENT,

                                    name VARCHAR(100),
                      type VARCHAR(50),
                      birth_date DATE,
                      owner_id BIGINT,
                      vet_id BIGINT,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      CONSTRAINT fk_pet_owner FOREIGN KEY (owner_id) REFERENCES petowners(id),
                      CONSTRAINT fk_pet_vet FOREIGN KEY (vet_id) REFERENCES vets(id)
);

-- Treatment Table
CREATE TABLE IF NOT EXISTS treatments (
                                          "ID" BIGINT PRIMARY KEY AUTO_INCREMENT,

                                          name VARCHAR(100),
                            description VARCHAR(255),
                            date DATE,
                            pet_id BIGINT,
                            vet_id BIGINT,
                            created_at TIMESTAMP,
                            updated_at TIMESTAMP,
                            CONSTRAINT fk_treatment_pet FOREIGN KEY (pet_id) REFERENCES pets(id),
                            CONSTRAINT fk_treatment_vet FOREIGN KEY (vet_id) REFERENCES vets(id)
);

-- Pet_Treatments (Join Table if Many-to-Many was intended)
CREATE TABLE IF NOT EXISTS pet_treatments (
                                pet_id BIGINT,
                                treatment_id BIGINT,
                                CONSTRAINT pk_pet_treatments PRIMARY KEY (pet_id, treatment_id),
                                CONSTRAINT fk_pt_pet FOREIGN KEY (pet_id) REFERENCES pets(id),
                                CONSTRAINT fk_pt_treatment FOREIGN KEY (treatment_id) REFERENCES treatments(id)
);
