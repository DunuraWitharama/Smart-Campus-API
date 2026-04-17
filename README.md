# Smart Campus IoT Management API
**Student Name:** Dunura Saradha Witharama 
**Student ID:** 20231815 / w2119959  
**Module:** Client-Server Architectures (5COSC022W)

# Smart Campus IoT Management API
**Student Name:** [Your Name]  
**University of Westminster**

## Project Introduction
This is a REST API built to manage a university campus. It allows the university to track **Rooms** and **Sensors** (like temperature or motion detectors). 

---

## 1. How to Run the Project
1.  **Open in VS Code:** Ensure the Java Extension Pack is installed.
2.  **Maven:** The project uses Maven to handle libraries (Jersey and Grizzly).
3.  **Start Server:** Run the `Main.java` file.
4.  **Access:** The API is live at `http://localhost:8080/api/v1/`.

---

## 2. Technical Analysis (Report)

### 2.1 JAX-RS Lifecycle and Data Synchronization
In this project, JAX-RS uses a "Request-scoped" lifecycle. This means a new instance of the resource class is created for every single request. Because these instances don't stay alive, data cannot be stored inside them. 

I solved this by using a **static DataStore** with `ConcurrentHashMap`. I chose this specifically to handle "Thread Safety." Since multiple users might call the API at once, the `ConcurrentHashMap` ensures that the data stays synchronized and the server doesn't crash from "race conditions."

### 2.2 Benefits of the Discovery Endpoint
I implemented a root endpoint at `/api/v1/` using **HATEOAS** principles. Instead of relying on a static PDF for documentation, the API is "self-documenting." This allows client developers to discover available resources (like rooms and sensors) dynamically. If the URL structure changes in the future, the client software won't break because it follows the links provided by the server.

### 2.3 Sensor Validation Logic
To maintain data integrity, the API ensures that a sensor cannot be registered to a room that doesn't exist. Before saving a sensor, the code validates the `roomId`. If the ID is not found in the DataStore, the server returns a **400 Bad Request**. This prevents "orphan data" and ensures every sensor is correctly linked to a physical location.

### 2.4 Error Mapping (422 vs 404)
I used custom Exception Mappers to return clean JSON error bodies. For payload issues, I use the **422 Unprocessable Entity** status. This is better than a **404** because a 404 suggests the endpoint doesn't exist, whereas a 422 correctly identifies that the server found the endpoint but the data provided was semantically incorrect.

### 2.5 Security and the Global Safety Net
I implemented a catch-all Exception Mapper for `Throwable` types. This acts as a **Cybersecurity Safety Net**. By intercepting unexpected errors, I prevent the server from sending "Stack Traces" to the user. Stack traces are dangerous because they expose internal file paths and library versions, which hackers use to find vulnerabilities. My mapper returns a clean **500 Internal Server Error** instead.

---

## 3. API Endpoints
| Method | URL | Description |
| :--- | :--- | :--- |
| GET | `/api/v1/` | API Discovery (Links) |
| GET | `/api/v1/rooms` | List all rooms |
| POST | `/api/v1/rooms` | Create a room |
| GET | `/api/v1/sensors` | View all sensors (supports ?type= filter) |
| GET | `/api/v1/rooms/{id}/sensors` | View sensors in a specific room |