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
![userSavePostman](https://github.com/user-attachments/assets/70eb7482-5d2d-4ed9-a1a8-cd7b3acb4ed8)
- Get a user
![getUserPostman1](https://github.com/user-attachments/assets/a3cca587-2fa1-4862-a2f4-ba32b21a8611)
- Save a resume (specify owner's ID in request)
![saveResumePostman1](https://github.com/user-attachments/assets/b8d726e7-3899-4105-93be-0c671ce9c3ea)
- Delete a resume (specify resume's ID in request)
![deleteResumePostman](https://github.com/user-attachments/assets/76462fba-86ab-4f6f-95d1-723b7a36ae6a)
