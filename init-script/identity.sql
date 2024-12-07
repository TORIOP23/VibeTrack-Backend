-- Create database
CREATE DATABASE identity;

-- Create user
CREATE USER 'identity'@'%' IDENTIFIED BY 'password';

-- Grant privileges for the identity database
GRANT ALL PRIVILEGES ON identity.* TO 'identity'@'%';

-- Apply the changes
FLUSH PRIVILEGES;

-- Note: In MySQL, schema creation is not needed explicitly for a user.
-- The application will create the tables and schema as needed.
