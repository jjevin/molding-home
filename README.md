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

To run the collection of services, run the following commands:

```bash
mvn clean package
docker compose build --no-cache
docker compose up
```

We are using automated mapping of routes, so it might take a while for all mappings to be created.
Check the "Get Routes" test in postman to confirm mappings are created.

## User Registration

To register a user, visit [this page](http://keycloak:8080/realms/molding/account).

- This is necessary, since importing / exporting users is not supported in the latest version of keycloak (to my knowledge).
- Create a user with username "molding-user" with the password "pass" for default endpoint testing.

## Endpoint Testing

This parent directory has Postman tests for each service. 

