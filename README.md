
# 🌐 Idioma / Language  
> 📌 **Select your language:**  
> - [🇪🇸Español](README.es.md)  
> - [🇬🇧**English**](README.md) (current)  
---


# 🏥 Patient Management System  
**Clinic "UTN-Medical Center"**  
**⚠️ Technical Requirements: The project must be developed in Java using JavaFX for the graphical user interface, and must strictly follow the MVC (Model–View–Controller) design pattern.**


## 🎯 General Objective  
Develop a desktop application for managing patients and medical appointments in a clinic. The application must be modular, efficient, and follow best development practices including:
- Language: **Java**  
- Interface: **JavaFX**  
- Architecture: **MVC (Model–View–Controller)**  
- Persistence: Initial configuration from `.json` files and database management using **JPA (Java Persistence API)**  


## 🧱 Project Structure (MVC Format)

### Model (`model`)  
Contains classes that represent data and business logic:
- `Patient`
- `Appointment`
- `Clinic`
- Utility classes for validations and payment calculations

### View (`view`)  
Graphical interface built with **JavaFX**:
- Screens for registering patients, appointments, handling attendance, payments, reports, etc.
- Visual elements (FXML, view controllers, etc.)
- Input fields validated visually (age, insurance, name, etc.)

### Controller (`controller`)  
Manages the interaction logic between model and view:
- Handles events from the GUI (e.g., "Register patient" button)
- Validates and processes data with help from the model
- Updates the GUI based on results


## 📋 Entities and Attributes

### 🧍 Class `Patient`
- `id`: auto-increment, unique
- `firstName`, `lastName` (letters only, max 30 characters)
- `dni`: unique
- `age` (18–90)
- `registrationDate`
- `insurance`: Swiss Medical, Apres, PAMI, Private

### 🗓️ Class `Appointment`
- `id`: auto-increment, unique
- `patientId`: must refer to an existing patient
- `specialty`: must be one of the allowed options
- `amountToPay`: automatically calculated
- `status`: “Active”, “Completed”, “Paid”

### 🏢 Class `Clinic`
- `businessName` (string)
- `patients` (list)
- `appointments` (list)
- `specialties` (dictionary)
- `acceptedInsurances` (dictionary)
- `revenue` (float)
- `hasPendingPatients` (boolean)


## 🧠 Important Validations

- **Age**: numeric, between 18 and 90  
- **Insurance based on age**:
  - ≥ 60: only PAMI allowed
  - < 60: PAMI not allowed
- **Specialties**: General Medicine, Dentistry, Psychology, Traumatology  
- **Initial appointment status**: “Active”  
- **Base appointment fee**: $4000, with the following adjustments:

| Insurance      | Discount/Surcharge     | Extra Condition                          |
|----------------|------------------------|-------------------------------------------|
| Swiss Medical  | -40%                   | Age 18–60: additional -10%                |
| Apres          | -25%                   | Age 26–59: additional -3%                 |
| PAMI           | -60%                   | Age ≥ 80: additional -3%                  |
| Private        | +5%                    | Age 40–60: additional +15%                |


## 🧭 Menu Features (JavaFX GUI)

1. **Register patient**
2. **Create appointment**
3. **Sort appointments**
   - By Insurance ASC
   - By Amount DESC
4. **Show patients in waiting**
5. **Attend patients**
   - Change up to 2 appointments from “Active” to “Completed”
6. **Charge for appointments**
   - Change status from “Completed” to “Paid”
   - Add amount to clinic `revenue`
7. **Close cashier**
   - Only if there are no “Active” or “Completed” appointments
   - Save patients and appointments to JSON
   - Otherwise, show warning message
8. **Total revenue from Swiss Medical patients over 21 
9. **Exit**


## 💾 Persistence and Required Technologies

- Dual persistence strategy:
  - Initial configuration from `configs.json`
  - **Relational database using JPA** to store patients, appointments, and revenue
- JPA entities and repositories must be properly defined
- Full CRUD operations must be implemented using the database

## 🧱 Technical Requirements

- Language: **Java**  
- GUI: **JavaFX** (FXML optional but recommended)  
- Architecture: **Strictly MVC**  
- Must apply:
  - Control structures
  - Loops
  - Custom validation functions
  - OOP principles (encapsulation, inheritance, polymorphism, abstraction)
  - Sorting algorithms
  - Use of `filter`, `map`, and lambda expressions (`Streams` in Java 8+)
- Clean and well-documented code
- Organized in packages:
  - `model`, `view`, `controller`, `utils` (optional)





