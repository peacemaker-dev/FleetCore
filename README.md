# FleetCore

Desktop logistics and fleet management system for freight operators, built in Java.

## Problem

Small and mid-sized freight operators track dispatch on spreadsheets, paper and
WhatsApp. That causes double-booked drivers and vehicles, orders that fall through
the cracks, and no single place to see fleet status.

## What it does

Centralises customers, freight orders, cargo, drivers and vehicles, and enforces
business rules so a driver or vehicle can't be double-booked and an order can't
skip a status it hasn't reached.

## Tech stack

- Java, Swing (UI)
- MySQL, JDBC (persistence)
- Maven
- NetBeans

## Project structure


## Getting started

1. Install JDK, MySQL Server and MySQL Workbench.
2. Clone the repo and open it in NetBeans as a Maven project.
3. Run the schema script in `database/` against your local MySQL instance
   (once it's added).
4. Set your local database credentials in [config file, once it exists] —
   never commit real credentials.
5. Run `FleetCore.java`.

## Branching

- `main` — stable
- `development` — integration branch
- `feature/<name>` — one branch per feature, merged into `development` via pull
  request

## Status

Domain model and exceptions complete. Database schema and DAOs in progress.

## License / ownership

Private project. Not licensed for external use. Contributor terms covered
separately.
