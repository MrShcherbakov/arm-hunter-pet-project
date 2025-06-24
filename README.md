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
<br/>**Attention, Kafka may take up to 5 minutes to start without cache:**
![timeToReady](https://github.com/user-attachments/assets/cc4f3c2f-90ef-4e45-b687-9d15f5fe8566)
- git init . – Initialize a local repository
- git pull https://github.com/MrShcherbakov/arm-hunter-pet-project.git master – Pull the project
- mvn install – Build the project
- docker compose up – Start services
**To see the endpoints look at the next title postman**
# Postman
- Save a user
![postmanSaveUser](https://github.com/user-attachments/assets/94976d1a-669b-4a7f-b5cb-5b4be05888f8)
- Get a user
![postmanFindUser](https://github.com/user-attachments/assets/d3d9cd7d-d8c3-43db-a021-da77026ea3ce)
- Save user's resume (specify owner's ID in request)
![postmanSaveResume](https://github.com/user-attachments/assets/5ec75e01-7329-454c-b5fd-eae7b9ae8cf1)
- Get a user with resume (user's field set to null to avoid recursion)
![postmanFindUserAgain](https://github.com/user-attachments/assets/f4089110-cfbb-4396-aaab-ebb991cf6cae)
