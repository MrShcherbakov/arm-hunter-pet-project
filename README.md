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
![userSavePostman](https://github.com/user-attachments/assets/6ceb70d7-6b41-4423-8d39-f2c746458afa)
- Get a user
![getUserPostman](https://github.com/user-attachments/assets/e212b364-4e4b-481c-b247-349c97a44cbf)
- Save a resume (specify owner's ID in request)
![resumeSavePostman](https://github.com/user-attachments/assets/0ccaaf3a-a202-484e-bd41-77569a7fdb29)
- Delete a resume (specify resume's ID in request)
![deleteResumePostman](https://github.com/user-attachments/assets/76462fba-86ab-4f6f-95d1-723b7a36ae6a)
