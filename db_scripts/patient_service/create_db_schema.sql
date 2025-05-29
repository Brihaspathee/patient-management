-- Run the following SQL command to create a separate database:
-- Login to postgres db using root user(postgres) and password(cognizant)
CREATE DATABASE patient_service_db;

-- use postgres root username and password and connect to the patient_service_db and run the following commands

-- Create a new user specifically for this database:
CREATE USER patient_service_admin WITH PASSWORD 'password';

-- Grant the user permissions to the database:
GRANT ALL PRIVILEGES ON DATABASE patient_service_db TO patient_service_admin;


-- Login to patient_service_db using the username patient_service_admin and password and execute the following commands

-- Create a schema for organizing tables:
CREATE SCHEMA patient_service AUTHORIZATION patient_service_admin;

-- Set the default schema for the user:
ALTER ROLE patient_service_admin SET search_path TO patient_service;
