Library Management System – Low Level Design (Java + Spring Boot + JPA)

# 📚 Library Management System

A professional **Library Management System backend** built using **Java, Spring Boot, JPA (Hibernate), and H2**.

This project is designed as a **Low Level Design (LLD) practice system** to demonstrate how real-world backend systems are architected using:
- Domain Driven Design
- Clean OOP principles
- Proper Entity modeling
- Service layer separation
- Strategy Pattern
- Database normalization
- Production-ready design practices

---

## 🚀 Features

### 👤 Members
- Register library members
- Unique barcode per member
- View borrowed books
- Reservation tracking

### 📖 Books
- Search by:
    - Title
    - Author
    - Category
    - Publication
- Multiple copies per book
- Rack-based physical location

### 📦 Book Items (Copies)
- Each copy has:
    - Unique barcode
    - Availability status
    - Linked to parent book

### 🔁 Checkout / Loan
- Borrow books
- Return books
- Max 5 books per member
- 10-day due date limit

### 🕒 Reservation
- Reserve unavailable books
- Queue-based reservations
- Auto-notification when available

### 💰 Fine System
- Late return fine calculation
- Payment tracking

### 🔔 Notification System
- Reservation available alerts
- Due date reminders

---

## 🏗️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17+ |
| Framework | Spring Boot |
| ORM | JPA / Hibernate |
| Database | H2 (In-Memory) |
| Build | Maven |
| Patterns | Strategy, Service Layer, Repository |
| Tools | Lombok |

---

## 📐 Architecture

### High Level Flow

<img width="812" height="863" alt="image" src="https://github.com/user-attachments/assets/d73e9e38-b91f-424c-a576-c76ae4c26680" />


### Patterns Used

### ✅ Strategy Pattern
Search implementation:
SearchByTitle
SearchByAuthor
SearchByPublication

### ✅ Observer Pattern

"When a book becomes available, I publish a domain event. ReservationListener listens and notifies the next user. This decouples circulation from notification and follows the Observer pattern."


## 🧩 Key Learnings

This project helped me practice:

✔ Entity Relationship modeling  
✔ JPA mapping strategies  
✔ Enum handling  
✔ Foreign key design  
✔ Low-level system design  
✔ Clean code architecture  
✔ Service separation  
✔ Interview-style backend design  

---

## 🎯 Future Improvements

- REST APIs
- Authentication
- Barcode scanner integration
- Pagination
- Caching (Redis)
- Dockerization
- PostgreSQL support
- Unit Tests
- Event-based notifications

---

## 👨‍💻 Author

**Prabal Saxena**

Software Engineer | Java | Spring Boot | Cloud

---

## ⭐ Why this project?

This is not just a CRUD app.

It is intentionally built to simulate:
- Real enterprise design
- Interview system design rounds
- Production-ready architecture
