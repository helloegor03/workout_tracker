WorkoutTracker 🏋️

Простое и удобное веб-приложение для отслеживания тренировок. Пользователь может создавать, просматривать и управлять своими тренировками после авторизации.

## 🚀 Возможности

- Регистрация и авторизация пользователей (JWT)
- Создание и просмотр тренировок
- Привязка тренировок к конкретному пользователю
- REST API с Spring Boot
- Хранение данных в PostgreSQL

## 🛠️ Стек технологий

- Java 17+
- Spring Boot
- Spring Security + JWT
- JPA / Hibernate
- PostgreSQL
- Maven

## 📦 Установка

```bash
git clone https://github.com/helloegor03/workout-tracker.git
cd workout-tracker
./mvnw spring-boot:run

1. Регистрация пользователя
POST /auth/signup

json
Copy
Edit
{
  "username": "johndoe",
  "email": "johndoe@example.com",
  "password": "yourPassword123"
}
🔐 2. Авторизация (вход в систему)
POST /auth/signin

json
Copy
Edit
{
  "username": "johndoe",
  "password": "yourPassword123"
}
📌 Ответ:

json
Copy
Edit
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Скопируй token и вставь его в Authorization → Bearer Token для следующих запросов.

🏋️‍♂️ 3. Создание новой тренировки
POST /api/workouts

Headers:

pgsql
Copy
Edit
Authorization: Bearer JWT_TOKEN
Content-Type: application/json
Body:

json
Copy
Edit
{
  "name": "Back Day",
  "type": "Strength",
  "duration": 45,
  "date": "2025-04-10"
}  
