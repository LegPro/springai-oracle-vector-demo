# Spring AI Oracle Vector Demo

This project demonstrates how to use **Oracle** as a vector store in a Spring Boot application. The application provides functionality for loading documents, splitting them into tokens, and performing similarity searches using vector embeddings generated via OpenAI's API.

## Prerequisites

- **Java 21**
- **Maven**
- **Docker**
- **Oracle Database** (running in a Docker container)
- **OpenAI API Key** for generating vector embeddings

## Getting Started

### 1. Run Oracle in Docker

To run an Oracle instance locally, you can use Docker. Run the following command to spin up a container:

```bash
docker run --rm --name oracle23ai -p 1521:1521 -e APP_USER=mlops -e APP_USER_PASSWORD=mlops -e ORACLE_PASSWORD=mlops gvenzl/oracle-free:23-slim
```

This will start Oracle with the necessary environment variables (`APP_USER`, `APP_USER_PASSWORD`, `ORACLE_PASSWORD`) and expose the necessary port (`1521`).

### 2. Install Oracle JDBC Driver (If Needed)

In case you encounter any issues related to the Oracle JDBC driver during bean creation, run the following Maven command to manually install the Oracle JDBC driver:

```bash
mvn install:install-file -Dfile=ojdbc11.jar -DgroupId=com.oracle.database.jdbc -DartifactId=ojdbc11 -Dversion=23.5.0.24.07 -Dpackaging=jar
```

This will fix the JDBC-related issues and allow the application to communicate with Oracle.

### 3. Add OpenAI API Key

You must add your **OpenAI API key** to the project. This key is used to generate the vector embeddings for documents in the application. Make sure to configure the OpenAI API key in your application before running the project.

### 4. Running the Application

To run the application, use the following Maven command:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application and expose the API endpoints for loading documents and performing vector similarity searches.

### 5. REST API Endpoints

The project provides two REST API endpoints:

#### 1. Load Documents
- **URL**: `/load`
- **Method**: `GET`
- **Description**: This endpoint loads a set of predefined documents into the Oracle vector store.

Example request:

```bash
curl http://localhost:8080/load
```

#### 2. Search Documents
- **URL**: `/search`
- **Method**: `GET`
- **Description**: This endpoint performs a vector-based similarity search to find the most relevant documents based on the query.

Example request:

```bash
curl "http://localhost:8080/search?query=Technology"
```

The response will return a list of document contents that are most similar to the query based on cosine similarity.
