---
# Arikkai Malar (அறிக்கை மலர்) 📰

A robust backend service for a job posting application, inspired by a full-stack project challenge from the [Telusko](https://www.youtube.com/@Telusko) YouTube channel. While the original project was a job portal, this version is reimagined as "Arikkai Malar" (Newspaper Blossom), a digital version of a newspaper's classifieds section for job advertisements.

This project focuses solely on the backend, providing a secure and functional set of API endpoints built with Spring Boot and MongoDB. It handles everything from user authentication to creating and searching for job postings.

---

## ✨ Features

* **Secure Authentication:** User registration and login functionality secured with **Spring Security** and **JWT (JSON Web Tokens)**.
* **Job Post Management:** Full CRUD (Create, Read, Update, Delete) capabilities for job postings.
* **Custom Fields:** Includes specific fields like `interviewTime` and `interviewPlace` for clearer job descriptions.
* **API-First Design:** All functionalities are exposed via a RESTful API, testable with tools like Postman.

---

## 💻 Tech Stack

* **Framework:** Spring Boot
* **Database:** MongoDB
* **Security:** Spring Security, JWT
* **Build Tool:** Maven

---

## 🎓 Learning Outcomes

This project was a fantastic learning experience that solidified my understanding of core backend development concepts. Key takeaways include:

* **RESTful API Design:** Gained practical experience building and structuring REST APIs using `@RestController`.
* **Layered Architecture:** Implemented a clear separation of concerns by organizing the code into distinct layers: **Controller, Service, Repository, Model, Config, and Filter**.
* **Database Integration:** Learned to seamlessly connect a Spring Boot application with a NoSQL database (MongoDB) using Spring Data.
* **API Testing:** Became proficient in using Postman to test various HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) and validate API responses.
* **Advanced Security:**
    * Implemented standard username/password authentication using Spring Security.
    * Elevated the security model by integrating stateless, token-based authentication with JWT.

---

## 🛠️ API Endpoints

The following endpoints are available. Note that protected routes require a valid JWT Bearer token in the `Authorization` header.

| Method | Endpoint                  | Description                      | Security   |
| :----- | :------------------------ | :------------------------------- | :--------- |
| `POST` | `/register`               | Register a new user.             | Public     |
| `POST` | `/mylogin`                | Authenticate a user and get JWT. | Public     |
| `GET`  | `/getjobs`                | Get a list of all job posts.     | Protected  |
| `POST` | `/postjobs`               | Create a new job post.           | Protected  |

---

## 🚀 Future Enhancements

This project is currently backend-only, but the plan is to build it into a complete full-stack application.

* **Frontend Development:** Build a responsive and user-friendly frontend using a modern framework like **React** or **Angular**.
* **OAuth2 Integration:** Implement social login options (e.g., Google, GitHub) using **OAuth2** for enhanced user convenience and security.
