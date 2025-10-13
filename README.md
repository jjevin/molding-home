# CSI5347 Semester Project

Author: Kevin Fritz

Title: Molding@Home

## Project Summary

A microservice project inspired by "Folding@Home". Comprised of the following services:

1. AssignmentService - Tracks the assignment of work units to clients
2. ClientService - Tracks users and manages user scores
3. WorkService - Manages problems, problem frames, and particles
4. ConfigService - Configuration image used by all other services

## Deployment

Each directory represents a service meant to be run independently, excluding ConfigService (which is used by each other service).
To run a service, navigate to that service's directory and run the following commands:

```bash
mvn clean package
docker compose build --no-cache
docker compose up
```

## Endpoint Testing

This parent directory has Postman tests for each service. 
Because each service is run individually, only run the series of tests corresponding to the running service.
