# Building a Microservice with Spring Boot, Kafka, Docker, and Redis for BrainStation-23 test


## Technology used in Project

- Spring Boot
- MySQL
- Kafka
- Redis
- Docker

## cURL of Implemented Rest API's

- Create a New User - 
```
curl --location 'http://localhost:8080/user/save' \
--header 'Content-Type: application/json' \
--data-raw '{
  "username": "test-kafka3",
  "email": "test-kafka2.hasnat@demomail.com",
  "name": "test-kafka2 hasnat",
  "age": 18
}'
```
- Retrieve User Details by ID
```
curl --location 'http://localhost:8080/user/get/2'
```

- Update User Details by ID
```
curl --location --request PUT 'http://localhost:8080/user/update/4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 4,
    "username": "test",
    "email": "test.hasnat@demomail.com",
    "name": "test hasnat",
    "age": 18,
    "active": true
}'
```
- Delete User by ID
```
curl --location --request DELETE 'http://localhost:8080/user/delete/3'
```
- Retrieve ALl User Details 
```
curl --location 'http://localhost:8080/user/get-all'
```


## Instruction to create Application Image From Docker File

- Create .jar file using the following command
```
mvn clean install
```
- Use the following command from the `Dockerfile` file directory
```
docker build -t <image_name> .
```
- Use the following command to run the image
```
docker run -p <host_port>:<container_port> --name <container_name> <image_name> 
```


## Instruction to build and run Application From Docker Compose File

- Use the following command from the `docker-compose.yml` file directory
```
docker compose up -d
```


> **_Note :_** Check your `Host Ip` address and place it in `application.properties` file.
