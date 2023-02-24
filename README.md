# Hibernate Search + Spring JPA

## Embedded database
To debug h2 database -> [http://localhost:9000/h2-console]()

## Oracle
Create an account and accept the T&C of the enterprise container: [https://container-registry.oracle.com/]()

- Log into docker CLI
```shell
docker login container-registry.oracle.com
```
- Pull the container image

```shell
docker pull container-registry.oracle.com/database/enterprise:12.1.0.2
```

- Either run the container directly through a docker command or use the docker-compose file
```shell
docker run -d --name oracle-db -p 1521:1521 -e ORACLE_PWD=<password> container-registry.oracle.com/database/enterprise:12.1.0.2
# or run it in detached mode (in the same folder which contains the docker.compose.yml file)
docker compose up -d
```
