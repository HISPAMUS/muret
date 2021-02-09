# Spring
The backend has been developed with the Spring Boot framework.
## Projections
These projections are used from API rest calls.

![Spring projections class diagram](puml/spring/spring_projections.svg)

-----
## REST API
The following table summarizes which class resolves each request

| **REST Method** | **Class** | 
| --- | ----------- |
| `/documents/<document ID>/sections` | `DocumentRepository` |
| `/documents/<document ID>/parts` | `DocumentRepository` |
