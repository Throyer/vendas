## Sumario

- [Demo](#demo)
- [Requisitos](#requisitos)
- [Database Migrations](#database-migrations)
- [Docker](#docker)

# Demo
![](./assets/venda.gif)

## Requisitos

- Postgres: `^13`
- Java: `^17`
- Maven: `^3.8.4`

## Database Migrations
> 🚨 cerifique de que tem o maven no seu ambiente
> e que você esta no diretório __./api__

Criando arquivos de migração de banco de dados

- Baseado em arquivo java
  ```bash
  mvn migration:generate -Dname=my-migration-name
  ```

- Baseado em arquivo sql
  ```bash
  mvn migration:generate -Dname=my-migration-name -Dsql
  ```

## Docker
> 🚨 certifique que o arquivo de `environment` foi criado
>
> ```bash
>   cp docker/.env.example docker/.env
> ```

- docker compose development
    ```bash
    docker-compose -p vendas-development -f ./docker/docker-compose.dev.yml --env-file ./docker/.env up -d --force-recreate
    ```

- docker compose production
    ```bash
    docker-compose -p vendas -f ./docker/docker-compose.prod.yml --env-file ./docker/.env up -d --build
    ```