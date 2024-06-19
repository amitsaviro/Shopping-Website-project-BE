# Shopping Website Backend

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Introduction

Provide a brief overview of your project. Mention its purpose and key functionalities.

---

## Features

List the main features or functionalities of your Shopping Website backend project.

- **Authentication**: JWT-based authentication for secure user login and registration.
- **Customer Management**: CRUD operations for managing customer profiles.
- **Items Management**: APIs for creating, retrieving, updating, and deleting items.
- **Order Management**: Handling orders, order items, and favorite lists.
- ...

---

## Technologies Used

List the technologies and frameworks used in your project.

- Java
- Spring Boot
- H2 SQL Database
- JWT for authentication
- Gradle for build automation

---

## Installation

Provide instructions on how to clone and set up your project locally.

```bash
git clone https://github.com/amitsaviro/Shopping-Website-project-BE.git
cd Shopping-Website-project-BE
./gradlew build
 ```
---
## Setup
Before running the server, make sure to set up the following configuration:

- Modify application.properties file to configure database connection details (spring.datasource.url, spring.datasource.username, spring.datasource.password).
- Configure JWT secret key in the application properties (jwt.secret)
- Any other setup steps specific to your project.
---
## API Endpoints 
Document the APIs provided by your backend.

### Authentication Controller

#### Create Authentication Token

- **Endpoint**: `POST /authenticate/create`
- **Description**: Create authentication token for user login.
- **Request Body**: `AuthenticationRequest`
- **Response**: Returns JWT token upon successful authentication. Returns 403 Forbidden with message "Incorrect Username Or Password" on authentication failure.

---

### Customer Controller

#### Create Customer

- **Endpoint**: `POST /customer/create`
- **Description**: Create a new customer.
- **Request Body**: `Customer`

#### Update Customer

- **Endpoint**: `PUT /customer/update`
- **Description**: Update an existing customer.
- **Request Body**: `Customer`

#### Delete Customer by ID

- **Endpoint**: `DELETE /customer/delete/{customerId}`
- **Description**: Delete customer by ID.

#### Get Customer by ID

- **Endpoint**: `GET /customer/get/{customerId}`
- **Description**: Retrieve customer details by ID.

#### Get All Customers

- **Endpoint**: `GET /customer/getAllCustomer`
- **Description**: Retrieve all customers.

#### Find Customer by Username

- **Endpoint**: `GET /customer/getUserName/{username}`
- **Description**: Find customer by username.

---

### Favorite List Controller

#### Create Favorite List

- **Endpoint**: `POST /favoriteList/create`
- **Description**: Create a new favorite list entry.
- **Request Body**: `FavoriteList`

#### Update Favorite List

- **Endpoint**: `PUT /favoriteList/update`
- **Description**: Update an existing favorite list entry.
- **Request Body**: `FavoriteList`

#### Delete Favorite List Entry

- **Endpoint**: `DELETE /favoriteList/delete/{customerId}/{itemId}`
- **Description**: Delete favorite list entry by customer ID and item ID.

#### Get Favorite List by ID

- **Endpoint**: `GET /favoriteList/get/{favoriteListId}`
- **Description**: Retrieve favorite list entry by ID.

#### Get All Favorite Lists by Customer ID

- **Endpoint**: `GET /favoriteList/getAllFavoriteListByCustomerId/{customerId}`
- **Description**: Retrieve all favorite list entries for a customer.

---

### Item Controller

#### Create Item

- **Endpoint**: `POST /item/create`
- **Description**: Create a new item.
- **Request Body**: `Item`

#### Update Item by ID

- **Endpoint**: `PUT /item/update/{itemId}`
- **Description**: Update item by ID.
- **Request Body**: `Item`

#### Delete Item by ID

- **Endpoint**: `DELETE /item/delete/{itemId}`
- **Description**: Delete item by ID.

#### Get Item by ID

- **Endpoint**: `GET /item/get/{itemId}`
- **Description**: Retrieve item details by ID.

#### Get All Items

- **Endpoint**: `GET /item/getAllItems`
- **Description**: Retrieve all items.

---

### Order Item Controller

#### Create Order Item

- **Endpoint**: `POST /orderItem/create`
- **Description**: Create a new order item.
- **Request Body**: `OrderItem`

#### Update Order Item

- **Endpoint**: `PUT /orderItem/update`
- **Description**: Update an existing order item.
- **Request Body**: `OrderItem`

#### Delete Order Item by ID

- **Endpoint**: `DELETE /orderItem/delete/{orderItemId}`
- **Description**: Delete order item by ID.

#### Get Order Item by ID

- **Endpoint**: `GET /orderItem/get/{orderItemId}`
- **Description**: Retrieve order item details by ID.

#### Get All Order Items by Order List ID

- **Endpoint**: `GET /orderItem/getAllItemsByOrderListId/{orderListId}`
- **Description**: Retrieve all order items for a specific order list.

#### Delete All Order Items by Order List ID

- **Endpoint**: `DELETE /orderItem/deleteAllOrderItemByOrderListId/{orderId}`
- **Description**: Delete all order items associated with a specific order list.

---

### Order List Controller

#### Create Order List

- **Endpoint**: `POST /orderList/create`
- **Description**: Create a new order list.
- **Request Body**: `OrderList`
- **Response**: Returns the ID of the created order list.

#### Update Order List by ID

- **Endpoint**: `PUT /orderList/update/{orderListId}`
- **Description**: Update order list by ID.
- **Request Body**: `OrderList`

#### Delete Order List by ID

- **Endpoint**: `DELETE /orderList/delete/{orderListId}`
- **Description**: Delete order list by ID.

#### Get Order List by ID

- **Endpoint**: `GET /orderList/get/{orderListId}`
- **Description**: Retrieve order list details by ID.

#### Get Order Lists by Customer ID

- **Endpoint**: `GET /orderList/getOrderListByCustomer/{customerId}`
- **Description**: Retrieve all order lists associated with a customer.

#### Get Temporary Order List by Customer ID

- **Endpoint**: `GET /orderList/getTEMPorder/{customerId}`
- **Description**: Retrieve temporary order list for a customer.

---
## Usage

To start the server locally, follow these steps:

1. Ensure you have set up the project as described in the [Installation](#installation) section.
2. Run the following command to start the server:

```bash
./gradlew bootRun
```
3. The server will start locally at `http://localhost:8080`.

---

### Contributing

Contributions to this project are welcome. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

---

### License

This project is licensed under the [MIT License](LICENSE).



