# 🏬 Store Service

A Spring Boot backend service for managing store-related data, built with PostgreSQL and **PostGIS** for spatial data handling. Instead of directly retrieving from SQL, I use PostGIS for better performance.
This project demonstrates how to integrate geographic information (e.g., store locations, nearby search) into a modern RESTful application.

---

## 🚀 Why PostGIS?

PostGIS extends PostgreSQL with **geospatial capabilities**, enabling efficient storage and queries of location-based data.  
It allows developers to:

- Store and manage geometry data (points)
- Perform distance and area calculations directly in SQL
- Build features like **“find nearest store”**, and **“stores within radius”**
- Leverage spatial indexes for **high-performance** geolocation queries

Using PostGIS makes it easy to develop real-world features that depend on **maps and spatial intelligence**.

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Language** | Java 25 |
| **Framework** | Spring Boot |
| **Database** | PostgreSQL + PostGIS |
| **ORM** | Hibernate Spatial |
| **Validation** | Spring Boot Starter Validation |
| **Documentation** | SpringDoc OpenAPI (Swagger UI) |
| **Build Tool** | Maven |
| **Boilerplate Reduction** | Lombok 

