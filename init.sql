CREATE DATABASE identity;

-- Connect to the database to apply schema-specific grants
\c identity;

-- Create users and assign privileges
CREATE USER identity WITH PASSWORD 'password';

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE identity TO identity;

-- Grant privileges on the database
GRANT ALL PRIVILEGES ON DATABASE identity TO identity;

-- Grant privileges on the public schema
GRANT ALL ON SCHEMA public TO identity;

-- Ensure the user has ownership of the schema
ALTER SCHEMA public OWNER TO identity;

-- Grant privileges on all existing tables, sequences, and functions in the schema
GRANT ALL ON ALL TABLES IN SCHEMA public TO identity;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO identity;
GRANT ALL ON ALL FUNCTIONS IN SCHEMA public TO identity;

-- Set default privileges for newly created objects in the schema
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO identity;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO identity;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON FUNCTIONS TO identity;