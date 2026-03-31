# edusubmit-api-gateway

Spring Boot 4.x API Gateway for EduSubmit microservices.

## Tech Stack

- Java 25
- Maven
- Spring Boot 4.x
- Spring Cloud Gateway
- Eureka Client
- Config Client
- Spring Boot Actuator

## Package

`com.edusubmit.gateway`

## Features

- Runs on port `8080`
- Registers as Eureka client
- Reads central configuration from Config Server (`http://localhost:8888`)
- Route mappings:
  - `/student/**` -> `lb://student-service`
  - `/submission/**` -> `lb://submission-service`
  - `/file/**` -> `lb://file-service`
- Path prefix stripping enabled (`StripPrefix=1`) for all routes
- Health endpoint: `http://localhost:8080/actuator/health`

## Files

- `src/main/resources/application.yml` for app/eureka/actuator settings
- `src/main/resources/bootstrap.yml` for config-client bootstrap
- `src/main/java/com/edusubmit/gateway/config/GatewayRouteConfig.java` for route definitions

## Run

1. Ensure Java 25 and Maven are installed.
2. Start dependencies:
   - Config Server (`http://localhost:8888`)
   - Eureka Server (`http://localhost:8761`)
3. Run:

```bash
cd edusubmit-api-gateway
mvn spring-boot:run
```

## Build

```bash
cd edusubmit-api-gateway
mvn clean package
```

## Verify

- Gateway health: `http://localhost:8080/actuator/health`
- Example route call: `http://localhost:8080/student/health` -> forwarded to `student-service` as `/health`
# edusubmit-api-gateway
