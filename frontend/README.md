# photodump-frontend
Frontend for photodump.xyz

### Setup
An AngularJS app running on a Node server, on the same host machine as the backend (an EC2 instance)

Deployed using Docker/Docker Compose

HTTP traffic to port 80 on the instance is forwarded to 9001 for this app

Communicates with the Spring Boot backend via REST calls
