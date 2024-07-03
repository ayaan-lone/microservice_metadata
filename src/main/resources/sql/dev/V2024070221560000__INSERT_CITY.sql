 INSERT INTO city (name, state_id) VALUES ('Mumbai', (SELECT id FROM state WHERE name = 'Maharashtra'));
 INSERT INTO city (name, state_id) VALUES ('Pune', (SELECT id FROM state WHERE name = 'Maharashtra'));
 
 INSERT INTO city (name, state_id) VALUES ('Ahemdabad', (SELECT id FROM state WHERE name = 'Gujarat'));
 INSERT INTO city (name, state_id) VALUES ('Vadodara', (SELECT id FROM state WHERE name = 'Gujarat'));
 
 INSERT INTO city (name, state_id) VALUES ('Los Angeles', (SELECT id FROM state WHERE name = 'California'));
 INSERT INTO city (name, state_id) VALUES ('San Jose', (SELECT id FROM state WHERE name = 'California'));
 
 INSERT INTO city (name, state_id) VALUES ('Dallas', (SELECT id FROM state WHERE name = 'Texas'));
 INSERT INTO city (name, state_id) VALUES ('Houston', (SELECT id FROM state WHERE name = 'Texas'));