# photodump-backend
Backend for photodump.xyz

### Setup
A Spring Boot Java application running on embedded Tomcat container

Uses Hibernate to connect with a PostgreSQL RDS instance in AWS, and Gradle for dependency management and building

Has an admin dashboard for managing all images, controller by Spring Security. The dashboard is an Angular page hosted within the app.

Deployed using Docker/Docker Compose on an AWS EC2 instance
