# Anderlecht Community NGO - Evenementen Beheer

## Projectbeschrijving
Spring Boot webapplicatie voor het beheren van evenementen en locaties voor de Anderlecht Community NGO.

## Technologieën
- **Spring Boot 3.4.5** - Framework
- **Spring Data JPA** - Database
- **Spring Web** - Web layer
- **Spring Validation** - Form validatie
- **Thymeleaf** - Templates
- **MySQL Connector** - Database driver
- **Bootstrap 5.1.3** - CSS framework
- **DataTables 1.11.3** - Tabel functionaliteit
- **jQuery 3.5.1** - JavaScript
- **Java 17** - Runtime

## Installatie
```bash
git clone [repository-url]
mvn clean install
mvn spring-boot:run
```
Applicatie draait op: `http://localhost:8080`

**Database**: MySQL database vereist (configuratie in application.properties)

## Functionaliteiten
- Evenementen aanmaken en bekijken
- Locaties beheren
- Responsive design
- Form validatie
- Zoekbare evenemententabel

## Routes
- `/` - Overzicht evenementen
- `/new` - Nieuw evenement
- `/locations` - Locaties beheren
- `/details/{id}` - Evenement details
- `/about` - Over ons

## Database Modellen
**Event**: titel, beschrijving, datum/tijd, organisatie, email, locatie
**Location**: naam, adres, capaciteit

## Gebruikte Bronnen
- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [Thymeleaf Docs](https://www.thymeleaf.org/documentation.html)
- [Bootstrap 5 Docs](https://getbootstrap.com/docs/5.1/)
- [DataTables Docs](https://datatables.net/manual/)
- Oefeningen  uit de les (https://github.com/David-VS/students)
- Github copilot
- Claude voor deze README : https://claude.ai/share/4a7ddf97-39c1-4f04-a734-3d6992a380fe