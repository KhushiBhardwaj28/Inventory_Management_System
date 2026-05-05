# Inventory Management System

## Overview
Full-stack inventory management app with authentication, product/category/supplier management, sales/purchases tracking, and transaction history. Backend runs on Spring Boot; frontend is React. Database is Supabase Postgres (migrated from MySQL).

- Default admin user: `admin_ims@gmail.com` / `Password@1234`.

## Tech Stack
- Backend: Spring Boot 3, Spring Web, Spring Security (JWT), Spring Data JPA (Hibernate 6), ModelMapper (limited), Lombok, HikariCP
- Database: Supabase Postgres (JDBC, SSL `sslmode=require`)
- Build: Maven (wrapper `mvnw`)
- Frontend: React (CRA), React Router, Axios
- Testing: JUnit (backend)
- Migration: `pgloader` (Docker or WSL)
- Other: Node.js, npm

## Project Structure
- `src/main/java/com/Inv/InventoryMgtSystem`: Spring Boot application (controllers, services, repositories, security, dtos, enums)
- `src/main/resources/application.properties`: Datasource and application config
- `ims-react/`: React frontend
- `db/pgloader.load`: MySQL → Postgres migration script
- `product-images/`: Static product images (optional)

## Prerequisites
- Java 17+
- Node.js 18+
- Maven (use wrapper `./mvnw`)
- Supabase Postgres connection (pooler, SSL)
- Optional: Docker Desktop or WSL for `pgloader`

## Configuration
Edit `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://<supabase-pooler-host>:5432/postgres?sslmode=require
spring.datasource.username=<supabase-user>
spring.datasource.password=<supabase-password>
spring.jpa.hibernate.ddl-auto=update
# Optional dialect to silence auto-detection warnings:
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

- Security permits `/api/auth/**` and static product images `/products/**`.
- Admin user is seeded at startup if absent.

## Setup
### Backend
```
./mvnw clean install
./mvnw spring-boot:run
```

### Frontend
```
cd ims-react
npm install
npm start
```

Login using `admin_ims@gmail.com` / `Password@1234`.

## Data Migration (MySQL → Supabase Postgres)
Edit `db/pgloader.load` if needed:

- FROM: `mysql://<user>:<pass>@<host>/<db>` (default: `root:1234@localhost/Inventory`)
- INTO: `postgresql://<user>:<pass>@<supabase-pooler-host>:5432/postgres`
- SSL enforced with `sslmode='require'`
- Includes tables: `users`, `products`, `categories`, `suppliers`, `transactions`
- Post-load normalization for `transactions.transaction_type`

### Run via Docker (recommended)
```
docker pull dimitri/pgloader
docker run --rm -v "D:\InventoryManagementSystem(Full_Stack)\db:/work" dimitri/pgloader /work/pgloader.load
```
Note: If Docker can’t reach `localhost` MySQL, update the script `FROM` to use `host.docker.internal`.

### Run via WSL
```
wsl --install
# inside WSL
sudo apt update && sudo apt install -y pgloader
pgloader /mnt/d/InventoryManagementSystem(Full_Stack)/db/pgloader.load
```

### Verify in Postgres
Use Supabase SQL editor or `psql`:
```
SELECT count(*) FROM products;
SELECT count(*) FROM categories;
SELECT count(*) FROM transactions;
```

## API Highlights
- Auth: `POST /api/auth/login`, `POST /api/auth/register`
- Products: CRUD, image serving via `/products/**`
- Categories & Suppliers: CRUD
- Transactions: list/details, filters by month/year; types include `PURCHASE`, `SALE`, `RETURN_TO_SUPPLIER`

## Key Decisions
- Manual DTO mapping for Transactions to avoid ModelMapper complexity with nested JPA entities.
- Product deletion clears references in related transactions first to avoid FK violations.
- SSL required for Supabase Postgres connections.

## Development Notes
- Keep Supabase credentials out of VCS; use environment variables or secrets.
- If Hibernate logs dialect warnings, set explicit Postgres dialect.
- Frontend guards handle optional nested entities in transaction detail views.

## Scripts
- Backend:
```
./mvnw spring-boot:run
```

- Frontend:
```
cd ims-react
npm start
```

- Migration:
```
docker run --rm -v "D:\InventoryManagementSystem(Full_Stack)\db:/work" dimitri/pgloader /work/pgloader.load
```

## License
Proprietary; no license file included.
