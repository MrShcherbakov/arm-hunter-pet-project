# Description
This pet project is the rest copy of **head hunter** in some way. It has users, and one have their resumes.
## Stack:
- Spring Boot
- Spring Core
- Spring Web
- Spring Data Jpa
- Spring Kafka
- PostgreSQL
- MapStruct
- Lombok
# Architecture diagram
![SchemaPng](https://github.com/user-attachments/assets/a734655f-e9d9-40e2-b14b-8f43930eb97f)

# Run
Full command to run the microservices
# Postman
- Request to saving a user
![postmanSaveUser](https://github.com/user-attachments/assets/94976d1a-669b-4a7f-b5cb-5b4be05888f8)
- Request to get a user
![postmanFindUser](https://github.com/user-attachments/assets/d3d9cd7d-d8c3-43db-a021-da77026ea3ce)
- Request to save user's resume (in id you determine owner's id)
![postmanSaveResume](https://github.com/user-attachments/assets/5ec75e01-7329-454c-b5fd-eae7b9ae8cf1)
- Request to get a user after the saving of his resume (user is null to prevent the loop)
![postmanFindUserAgain](https://github.com/user-attachments/assets/f4089110-cfbb-4396-aaab-ebb991cf6cae)
