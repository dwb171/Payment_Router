# Payment Router

[![CI](https://github.com/dwb171/Payment_Router/actions/workflows/ci.yml/badge.svg)](https://github.com/dwb171/Payment_Router/actions/workflows/ci.yml)

A Spring Boot service that routes payments to the most appropriate payment rail (ACH, Wire, RTP).

> **Status:** early development. The service currently exposes the list of supported rails; routing logic, persistence, and payment submission are on the roadmap below.

## Tech stack

- Java 27
- Spring Boot 4.1 (Web MVC, Validation, Actuator)
- Maven (via the included wrapper)
- JUnit 5 / Spring Boot Test
- GitHub Actions for CI

## Getting started

### Prerequisites

- JDK 27

No Maven install is needed — use the `./mvnw` wrapper.

### Run the app

```bash
./mvnw spring-boot:run
```

The service starts on `http://localhost:8080`.

### Run the tests

```bash
./mvnw verify
```

## API

| Method | Path            | Description                     |
|--------|-----------------|---------------------------------|
| GET    | `/api/v1/rails` | List the supported payment rails |

Example:

```bash
curl http://localhost:8080/api/v1/rails
```

```json
["ACH", "WIRE", "RTP"]
```

### Health check

```bash
curl http://localhost:8080/actuator/health
```

## Payment rails

| Rail | Description |
|------|-------------|
| `ACH`  | Automated Clearing House — low cost, batch-based, settles in 1–2 business days |
| `WIRE` | Wire transfer — higher cost, same-day settlement, good for large amounts |
| `RTP`  | Real-Time Payments — instant settlement, 24/7, with per-transaction limits |

## Project structure

```
src/main/java/com/daveB/payment_router/
├── PaymentRouterApplication.java   # Spring Boot entry point
└── rail/
    ├── PaymentRail.java            # Supported rails
    └── RailController.java         # /api/v1/rails endpoint
```

## Roadmap

- [ ] Rail selection logic (cost, speed, amount limits)
- [ ] Payment submission endpoint with request validation
- [ ] PostgreSQL persistence with Flyway migrations
- [ ] Idempotency keys for safe retries
- [ ] Integration tests with Testcontainers
- [ ] Authentication (Spring Security + JWT)
- [ ] Payment events via Kafka
- [ ] Docker / docker-compose for local development
- [ ] Cloud deployment and observability (metrics, tracing)
- [ ] React + TypeScript dashboard
