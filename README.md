# Levantar ActiveMQ con Docker

## ActiveMQ dependencies

```bash
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-activemq</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.activemq</groupId>
			<artifactId>activemq-client</artifactId>
		</dependency>
```

## DOCKERFILE
```bash
FROM openjdk:17-jdk-slim
VOLUME /tmp

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/myapp-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## DOCKER-COMPOSE.YML

```bash
version: '3.8'

services:
  activemq:
    image: rmohr/activemq:5.15.9
    container_name: activemq
    ports:
      - "61616:61616"
      - "8161:8161"
    environment:
      - ACTIVEMQ_USER=admin
      - ACTIVEMQ_PASSWORD=admin
      - ACTIVEMQ_MIN_MEMORY=512
      - ACTIVEMQ_MAX_MEMORY=2048
      - ACTIVEMQ_ENABLE_JMX=true

  springbootapp:
    build:
      context: .
      dockerfile: src/main/docker/Dockerfile
    container_name: springbootapp
    ports:
      - "8080:8080"
    depends_on:
      - activemq
    environment:
      SPRING_ACTIVEMQ_BROKER-URL: tcp://activemq:61616
      SPRING_ACTIVEMQ_USER: admin
      SPRING_ACTIVEMQ_PASSWORD: admin
```

## Comando para levantar docker

```bash
docker-compose up --build
```

## Comando para bajarte ActiveMQ

```bash
docker stop activemq
```
