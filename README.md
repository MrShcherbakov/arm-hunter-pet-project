# Description
This pet project is a simplified REST-based version of HeadHunter. It has users, and one have their resumes.
## Stack:
- Spring Boot
- Spring Core
- Spring Web
- Spring Data JPA
- Spring Kafka
- PostgreSQL
- MapStruct
- Lombok
# Architecture diagram
![SchemaPng](https://github.com/user-attachments/assets/a734655f-e9d9-40e2-b14b-8f43930eb97f)

# Run instructions
1. Create an empty directory and navigate into it.
2. Run the following full command to set up and run the project:
`git init . && git pull https://github.com/MrShcherbakov/arm-hunter-pet-project.git master && mvn install && docker compose up`
<br/>**Attention, Kafka may take up to 5 minutes to start without cache**

- git init . – Initialize a local repository
- git pull https://github.com/MrShcherbakov/arm-hunter-pet-project.git master – Pull the project
- mvn install – Build the project
- docker compose up – Start services
**To see the endpoints look at the next title postman**
# Postman
- Save a user
POST http://localhost:8080/user/save
Body's example:
```
{
  "username": "Junior",
  "password": "qwerty"
}
```
- Get a user
GET http://localhost:8080/user/find/{id}
- Save a resume (specify owner's ID in request)
POST http://localhost:8080/resume/save
Body's example:
```
{
  "description": "example",
  "user": {
    "id": 1
  }
}
```
- Delete a resume (specify resume's ID in request)
POST http://localhost:8080/resume/delete/{id}
