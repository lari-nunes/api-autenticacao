# Autenticação API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este projeto é uma API construída usando **Java, Java Spring, Flyway Migrations, PostgreSQL como banco de dados, Spring Security e JWT para controle de autenticação.**

## Índice

- [Instalação](#instalação)
- [Configuração](#configuração)
- [Acessar Projeto](#Acessar)
- [API Endpoints](#api-endpoints)
- [Autenticação](#Autenticação)
- [Database](#database)


## Instalação

1. Clona o repository:

```bash
git clone https://github.com/lari-nunes/api-autenticacao.git
```

2. Instale dependências com Maven

3. Instala o banco de dados [PostgresSQL](https://www.postgresql.org/)

## Acessar Projeto
1. Inicie o aplicativo com Maven
2. A API estará acessível em http://localhost:8080

## API Endpoints
A API fornece os seguintes endpoints:

```markdown
GET /product - Recuperar uma lista de todos os produtos. (todos os usuários autenticados).

POST /product - Registre um novo produto (é necessário acesso de ADMIN).

POST /auth/login - Faça login na aplicativo.

POST /auth/register - Cadastre um novo usuário no aplicativo.
```

## Autenticação
A API usa Spring Security para controle de autenticação. As seguintes funções estão disponíveis:

```
USUÁRIO -> Função de usuário padrão para usuários logados.
ADMIN -> Função administrativa para parceiros gestores (registo de novos parceiros).
```
- Para acessar endpoints protegidos como usuário ADMIN, forneça as credenciais de autenticação apropriadas no cabeçalho da solicitação.

## Database
O projeto utiliza [PostgresSQL](https://www.postgresql.org/) como banco de dados. As migrations de banco de dados necessárias são gerenciadas usando Flyway.
