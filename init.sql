CREATE DATABASE identity;

-- Create users and assign privileges
CREATE USER identity WITH PASSWORD 'password';

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE identity TO identity;
