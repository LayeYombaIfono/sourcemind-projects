# Utiliser une image de base OpenJDK légère
FROM openjdk:17-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier pom.xml et les fichiers Maven Wrapper (si disponibles)
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Résoudre les dépendances pour accélérer les futures builds
RUN chmod +x mvnw && ./mvnw dependency:resolve

# Copier le code source dans le conteneur
COPY src ./src

# Construire l'application
RUN ./mvnw package -DskipTests

# Exposer le port 8080
EXPOSE 8080

# Commande par défaut pour exécuter l'application
CMD ["java", "-jar", "target/*.jar"]
