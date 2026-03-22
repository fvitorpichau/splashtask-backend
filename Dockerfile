# ---- Build stage ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy Maven wrapper and config
COPY .mvn/ .mvn/
COPY mvnw mvnw
COPY pom.xml .

# Download dependencies (caches Maven repo layers)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application JAR
RUN ./mvnw package -DskipTests

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
