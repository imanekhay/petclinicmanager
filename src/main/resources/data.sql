-- Insert Address
INSERT INTO addresses ( city, country, street, zip, created_at, updated_at)
VALUES ( 'London', 'UK', 'Baker Street 221B', 'NW1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert PetOwner
INSERT INTO petowners ( name, email, phone, address_id, created_at, updated_at)
VALUES ('John Watson', 'watson@example.com', '123456789', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert Vet
INSERT INTO vets ( name, specialization, created_at, updated_at)
VALUES ( 'Dr. Holmes', 'Surgery', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert Pet
INSERT INTO pets ( name, type, birth_date, owner_id, vet_id, created_at, updated_at)
VALUES ( 'Doggo', 'Dog', '2020-01-15', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert Treatment
INSERT INTO treatments ( name, description, date, pet_id, vet_id, created_at, updated_at)
VALUES ( 'Dental Cleaning', 'Routine dental work', CURRENT_DATE, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
