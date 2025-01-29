-- Création de la table "user"
CREATE TABLE IF NOT EXISTS "user" (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255)
);

-- Création de la table "préférence"
CREATE TABLE IF NOT EXISTS préférence (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  type VARCHAR(255),
  user_id INTEGER REFERENCES "user" (id)
);

