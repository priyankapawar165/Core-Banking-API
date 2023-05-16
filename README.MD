# Core Banking API

This is backend application that allows to provide a list of REST API to support core banking application.

## Supports the below APIs

* Open an account
* Deposit money
* Withdraw money
* Generate statements

## Technology Stacks

* Core Java, Spring, Spring Boot, Rest API, Postgres 
* Tools - Intellij, Postman, Git, pgAdmin4
* Spring initializr - https://start.spring.io/

## Maven dependency

```xml
 <dependency>
<groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.postgresql</groupId>
<artifactId>postgresql</artifactId>
<scope>runtime</scope>
</dependency>
```

## Annotation Used 

* SpringBootApplication
* RestController
* RequestMapping
* Component
* PostMapping
* GetMapping
* NotBlank
* Valid


## Getting started

- clone a repo - https://github.com/priyankapawar165/Core-Banking-API.git
- Execute the SQLs - `resorces/core-banking-db.sql` file.
- Start the Spring Boot application - DataServer.java


## For Postman, cURLs
Create an Account API
```xml
curl --location 'http://localhost:8080/create-account' \
        --header 'Content-Type: application/json' \
        --data '{
        "name": "Tom",
        "address" : "New York",
        "accountType":"Saving Account"
    }'
```

Transaction API
```xml
- curl --location 'http://localhost:8080/execute_transaction' \
--header 'Content-Type: application/json' \
--data '{
"bankAccountId":"1",
"amount":"5",
"transactionType":"withdraw"
}'
```

Generate Statement API
```xml
curl --location 'http://localhost:8080/statement' \
        --header 'Content-Type: application/json' \
        --data '{
        "customerId": "5",
        "fromDate": "2023-04-23",
        "toDate": "2023-05-09"
     }'
```

