# VendingMachine

Please make sure you enable annotation processing. To configure annotation processing in IntelliJ IDEA, use dialog Preferences > Project Settings > Compiler > Annotation Processors

To run the project you need to create a Postgres DB running the compose.yaml file with the following command:  
docker-compose -f compose.yaml up -d

In order to run the application as a docker container follow the steps:  
1. Build the Docker Image:  
docker build -t noser-vending-machine .  
2. Run the Docker Container:  
docker run -p 8080:8080 noser-vending-machine  
Important: I couldn't add the Postgres compose file to the dockerization so this feature is still work in progress!

Please check Swagger Documentation in the following link:  
http://localhost:8080/swagger-ui/index.html
