# One Stop Citizen Service - a SOAP API based Application

## Overview

The One Stop Citizen Service (OSCS) is a groundbreaking SOAP API-based application designed to centralize and simplify access to various government and civic services in Bangladesh. This platform aims to empower citizens by providing them with an easy-to-use interface to connect with essential services and helplines under a single umbrella. Serving as a centralized hub, OSCS integrates a wide range of services into one user-friendly platform.
## How to Install

To install and run The OSCS application, follow these steps along with some minor configurations:

1. **Ensure Ports 8081 to 8085 are up & running and most importantly being FREE:**
   - To avoid conflicts, ensure that your system's ports 8081 to 8085 are free and unused..


2. **Clone the Repository:**
   ```sh
   git clone https://github.com/Nur-Quraishi/One-Stop-National-Citizen-Service---A-SOAP-Project.git
   cd  cd One-Stop-National-Citizen-Service---A-SOAP-Project
   
3. **Load Each Folder into IntelliJ:**
   - Download and install IntelliJ IDEA - 2023.3.4.
   - Open IntelliJ IDEA.
   - Load each folder (e.g., "citizenContactService", "commonService", "searchAndSortService", "sessionValidatorService" and "userService") as distinct spring boot web projects. To do this:
   - Click on File > Open.
   - Select the folder and click OK.
   - Follow the prompts to load the project.


4. **Setup MySQL Database**
   - Download and install MySQL Server, Shell and Workbench - 8.0 CE.
   - Import the "MySQL Database Schema" folder using Workbench 8.0 CE application with "root" privileges.
   - Create a database user named: "quraishi" and with the password: "123456".
   - Create a database schema named: "one_stop_citizen_service"
   - Provide all the privileges including "grant" permission to the above created user for the recently created schema.
   

5. **Run the Projects:**
    - For each loaded project, configure the run configurations if necessary.
    - Run each project to start their respective service.


6. **Conduct API Testing using Soap UI:**
    - Download and install Soap UI - 5.7.2.
    - Import each folder inside the "SoapUI Requests" folder using Soap UI application.
    - Test each of the APIs with the necessary parameter values.

## Application Context Flow

1. **User Account Registration and Authentication:**
   - User creates his/her account to enjoy these exciting services.
   - After creating an account, user authenticates him/herself with the following required credentials:
      - Sign in using "Email Address" and "Password"
      - Sign in using "Mobile Number" and "Password"
   - After successful authentication process, the user gets a "Session Token" with an "Expiry Date" attached by the system itself.
   - Each time whenever the user search for a "Contact Information" these above parameters are checked by the system to validate his/her session.


2. **Add Citizen Service Contact Information**
    - System admin needs to add all the citizen service contact details including their "Name", appropriate "Category" and "Contact Number".
       

3. **Search Request Management:**
   - After successful session validation, user performs search operation to fetch their desired contact details in the following processes:
       - Search contact by "Name", "Column To Be Sorted" and "Sort Order".
       - Search contact by "Category", "Column To Be Sorted" and "Sort Order".
       - Search contact by "Contact Number", "Column To Be Sorted" and "Sort Order".
   - Upon their request:
      - The relevant search results including contact details are served in the demanded sorting order.

## Services

### Entity Services
- **User Service:** Provides CRUD operations for users along with details.
- **Citizen Contact Service:** Manages citizen contact information and all the operations surrounded it.

### Utility Services
- **Common Service:** Contains common schemas used throughout the system to provide response "Status", "Code" and "Message" for each of the request made.

### Task Service
- **Session Validator Service:** Comprised of User Service to validate the user session.
- **Search And Sort Service:** Consolidates the Session Validator Service with the Citizen Contact Service to search and fetch the required information in a sorted way.

## SOA Principles

The OSCS is built upon the following SOA principles:

### 1. Service Contract and Standardization

Service contracts were standardized using various Functional Expression and Data Representation Standards.
#### Standardized WSDL Definitions
All WSDL definitions in the OSCS have been standardized to ensure consistency and clarity. The following conventions are followed:

- **Entity Services:** Named according to the corresponding business entities they represent.
- **Task Services:** Named based on the process they automate, prefixed with an appropriate verb.
- **Operations:** Named using the format: verb + noun.

###### Examples
- `getUserDatails` Operation
- `eavaluateSession` Operation
- `loginWithEmailRequest` Operation

#### Standardized Service and Data Representation Layers
Schema centralization is achieved by reusing preset schemas and creating new schemas only when needed. This solution keeps all schemas in a centralized repository, ensuring consistency and reuse throughout the program. Some of the examples are:

- `userDetails` schema is broken down to `userWithSessionDetails` and `userDetails`
- Response `Status`, `Code`, `fault` and `message` was moved to `CommonService` and reused in all services
- `searchAndSort` reuses the schemas defined in `sessionValidator, citizenContact` 

### 2. Loose Coupling
All of the services in our architecture have a high level of logic-to-contract coupling since they are bespoke services with standardized service contracts. The `User` and `Contact` services are built on the entity service paradigm, which minimizes any functional coupling with external or parent business process logic. The same is true for utility service - `Common`.

`SessionValidator`and `SearchAndSort` are task-centric services that are tied to the OSCS business process, which is a very particular operation within the OSCS application. As a result, this service exhibits targeted functional coupling, which was purposely included throughout its design.
### 3. Abstraction
Excluding the task services- `SessionValidator`and `SearchAndSort`, All services maintain the following levels of abstraction:

| **Abstraction Level**                  | **Description**                                                                                     |
|----------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Functional Abstraction (Content Abstraction)** | **Concise:** The service contract provides targeted functionality with limited constraints.          |
| **Technology Abstraction (Access Control)**      | **Open Access:** The technologies used to build and implement this service are openly documented and published as part of architecture specifications. |
| **Programmatic Abstraction (Access Control)**    | **Open Access:** Source code and design specifications are openly available on the local LAN.        |
| **Quality of Service (Access Control)**          | **Open Access:** The SLA is published alongside the service contract.                                |

#### Exception: `SessionValidator`and `SearchAndSort` Services

Because of its intricate business flow related to the transmission of order data, the two services mentioned above diverge from the typical levels of abstraction.

| **Abstraction Level**                  | **Description**                                                                                     |
|----------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Functional Abstraction (Content Abstraction)** | **Detailed:** Due to the complex business flow, this service’s contract has a low level of functional abstraction.          |

### 4. Reusability

The OSCS's entity and utility services are self-contained and do not depend on other service capabilities for reusability. They operate autonomously, offering reusable and modular functionalities that can be accessed by the task service when required.
#### Task Service and Entity Services

The task service, `SearchAndSort`, coordinates various operations that involve multiple entities, utilities, and other task services too. For instance, In the time of searching a contact detail by category, such as `National`, `Women and Children` or `Security`, multiple services (like- `sessionValidatorService` and `citizenContactService`) are internally invoked and utilized.

##### Example: Search by Name and Category.

When a search is performed using a name:
- At first the session of the current user gets validated. 
- Then the contact details are fetched similar to the search keyword and sorted in a certain direction based on the mentioned column as param.

Initially, the `getUser()` method was used to fetch the user details. However, it provides the entire user entity as output, which was irrelevant for validating session. To address this, a more specific operation named- `getUserWithSessionDetails()`, was introduced to specifically handle the session validation process.

Similarly, the operation to search contact was reformed by creating the `searchByName()` or `searchByCategory()` operation, not only depending on `searchContact()`. This method guarantees that the operations are effective and specific, which encourages improved reusability and maintainability of the services.


### 5 Autonomy

The OSCS features self-contained services, with each service storing its own data in a shared database hosted in `port: 3306` and having distinct business logic. This approach guarantees that services function autonomously, leading to improved modularity and maintainability which represents the concept of **shared-autonomy**.
#### Contract Denormalization
The **Contract Denormalization** was utilized to denormalize certain capabilities, enabling comprehensive operations to be divided into more specific ones, such as:
- `getUser()` was denormalized into `getUserWithSessionDetails()` and `getUserDetails()`.

The services were enhanced by introducing partially redundant capabilities to improve functionality and accessibility.
#### Service Autonomy

The `User Service` and `Citizen Contact Service` are autonomous in nature, meant that they do not rely on other services for their functionalities. Thus, they showed the characteristics of **`Pure Autonomy`**

#### Exception: Session Validator Service & Search and Sort Service

The `Session Validator Service` and `Search and Sort Service` are against the above autonomy. Both of them orchestrate the functionalities of the `User Service` and `Citizen Contact Service`, making it a shared service.The concept of **`Shared Autonomy`** implies that the mentioned services rely on other services to carry out their tasks, but they utilize their capabilities to effectively fulfill their specific functions.


### 6 Statelessness

All services in the OSCS are completely stateless. When these services were being implemented, REST routing conventions were adhered to in order to maintain stateless behavior:

- `create`
- `getById`
- `getAll`
- `update`
- `delete`

While some denormalization and redundant capabilities like- `getUserWithSessionDetails()`, `searchByName()` or `searchByCategory()` were added, the system as a whole stays stateless since it doesn't rely on previous request results. In the present solution, authentication, cookies, and other stateful mechanisms were left out, decreasing the chance of introducing statefulness even more. This guarantees that each service call stands alone, supporting scalability and simplicity.

### 7. Composability
All the services are highly composable, enabling their combination to form new composite services. For instance, the **`Search and Sort`** service incorporates features from the `Session Validator` and `Citizen Contact` services.

- The `searchByNameWithValidation()` validates the session information by calling `evaluateSession()` from **Session Validator Service**, then search the citizen contacts by calling `searchByName()` from **Citizen Contact Service**. Therefore the capability is a composition of capabilities from 2 other services.

### 8. Discoverability

In this SOA project, all services are intended to be easily found within the LAN. At present, services are not registered in a service registry but can be registered if required. They make use of standard interfaces, such as SOAP endpoints, to enable simple discovery and integration into composite services like- `searchByName` or `searchByCategory`. This method guarantees that services can engage and work together dynamically based on standardized protocols and interfaces.


## Conclusion

The **One Stop Citizen Service (OSCS)** is an adaptable and durable application designed with a focus on modularity, reusability, and adherence to SOA principles, guaranteeing a top-notch architecture that can easily adjust to evolving business needs while upholding efficiency and dependability.

## Contact

For any queries or further information, please contact the developer at [Email: <a href="mailto:nur.quraishi@gmail.com" target="_blank">nur.quraishi@gmail.com</a> or WhatsApp:  <a href="https://wa.me/+8801733999551" target="_blank">+880 17 33 999 551</a>].
