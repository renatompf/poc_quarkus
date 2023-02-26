# poc_quarkus


## Description

`poc_quarkus` it's was, as the name suggested, a POC made in [Quarkus](https://quarkus.io/) for me to understand how different it was from Spring Boot.

This POC was pretty simple and only implements a `GET`, a `POST` and a `DELETE` method.

It was implemented using [PostgreSQL](https://www.postgresql.org/) as a database, and the all system it's running on [Docker](https://www.docker.com/).

## How to run it

The simple command will make the application running:
```shell
./mvnw compile quarkus:dev && docker-compose up -d postgres
```

## Endpoints:

The application as very few endpoints:

* GET All the persons in the system:
```shell
localhost:8080/person/
```

* GET a single person in the system by his email:
```shell
localhost:8080/person/{email}
```

* Add (POST request) a person in the system:
  * Takes the new person as in the body of the request
```shell
localhost:8080/person
```

* DELETE a person in the system by his email:
```shell
localhost:8080/person/{email}
```
