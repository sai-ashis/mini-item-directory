# Mini Item Directory
A simple full-stack application that allows users to add items with name and category and search items by name.

## Live Demo Link
https://mini-item-directory.vercel.app/

## Tech Stack
Backend:
- Java 17 or higher
- Spring Boot 3

Frontend:
- Angular 19
- TypeScript

## Validation
- Item name is required
- Maximum length: 20 characters

## Run Backend in Local
Prerequisites:
- Java 17 or higher
- Maven

Commands:
- mvn clean install
- mvn spring-boot:run

Backend runs on:
http://localhost:8080

## Run Frontend in Local
Prerequisites:
- Node.js
- Angular CLI

Commands:
- ng serve

Frontend runs on:
http://localhost:4200

## API Endpoints
POST /items

Sample Request:
{
  "name": "Sherlock Holmes",
  "category": "Book"
}

Sample Response:
{
  "id": 1,
  "name": "Sherlock Holmes",
  "category": "Book"
}

GET /items?q=sher

Sample Response:
[
  {
    "id": 1,
    "name": "Sherlock Holmes",
    "category": "Book"
  }
]

## Testing
Example 1:
- Add Book "Sherlock Holmes"
- Search "sher"
- Result should contain "Sherlock Holmes"

Example 2:
- Submit empty name
- Receive HTTP 400 with field name and error message

Example 3:
- Submit name exceeding 20 characters
- Receive HTTP 400 with field name and error message

## Known Limitations
- Uses in-memory h2 database
- Data is lost when application restarts
- Search only supports name matching

## Approximate Hours Spent
Streamlined the development lifecycle by configuring, building, and deploying the complete application within an 8-hour window.

## Using AI
Throughout the process, I utilized Copilot and Claude to assist with the frontend development and to audit the codebase for efficiency and performance optimizations.
