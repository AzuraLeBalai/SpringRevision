FROM registry.tooling.nextoo.fr/nextoo-academy-former/training-course-correction/weather-project/weather-bdd-docker:1.0.0
WORKDIR /app
# Copie du script SQL pour créer les tables
COPY init.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
