
 
 
 INSERT INTO country (name) VALUES ('India');
 INSERT INTO country (name) VALUES ('USA');
 
 INSERT INTO state (name, country_id) VALUES ('Maharashtra', (SELECT id FROM country WHERE name = 'India'));
 INSERT INTO state (name, country_id) VALUES ('Karnataka', (SELECT id FROM country WHERE name = 'India'));
 INSERT INTO state (name, country_id) VALUES ('Tamil Nadu', (SELECT id FROM country WHERE name = 'India'));
 INSERT INTO state (name, country_id) VALUES ('Gujarat', (SELECT id FROM country WHERE name = 'India'));
 
 
 INSERT INTO state (name, country_id) VALUES ('California', (SELECT id FROM country WHERE name = 'USA'));
 INSERT INTO state (name, country_id) VALUES ('Texas', (SELECT id FROM country WHERE name = 'USA'));
 INSERT INTO state (name, country_id) VALUES ('Florida', (SELECT id FROM country WHERE name = 'USA'));
 INSERT INTO state (name, country_id) VALUES ('New York', (SELECT id FROM country WHERE name = 'USA'));
 