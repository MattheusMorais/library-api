<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
<div align="center">

[![Issues][issues-shield]][issues-url]
[![License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

</div>

<br>

<div align="center">

<a href="https://github.com/MattheusMorais/library-api">
<img src="images/library-api-banner.png" alt="Library API Banner" width="100%">
</a>

# 📚 Library API

Uma API REST para gerenciamento de livros e autores, desenvolvida com **Java** e **Spring Boot**, aplicando conceitos modernos de desenvolvimento backend, arquitetura em camadas, persistência de dados e boas práticas de engenharia de software.

O projeto foi criado com foco em organização, escalabilidade e manutenção, simulando cenários comuns encontrados em aplicações corporativas.

<br>

<a href="https://github.com/MattheusMorais/library-api/issues">Reportar Bug</a>

</div>

---

# 📖 Sobre o Projeto

A **Library API** é uma aplicação backend responsável pelo gerenciamento de uma biblioteca, permitindo o cadastro, consulta, atualização e remoção de livros e autores através de uma API REST.

O projeto foi desenvolvido para praticar conceitos essenciais do ecossistema Spring, incluindo:

- Arquitetura em camadas
- Desenvolvimento de APIs REST
- Persistência com banco de dados relacional
- Validação de dados
- Tratamento global de exceções
- DTOs e mapeamento de objetos
- Boas práticas de organização de código

A aplicação segue uma arquitetura desacoplada, facilitando testes, manutenção e futuras expansões.

<div align="center">

<img src="images/swagger.png" width="80%">

</div>

---

# 🛠️ Tecnologias

<div align="center">

![Java][Java]
![SpringBoot][SpringBoot]
![SpringData][SpringData]
![PostgreSQL][PostgreSQL]
![Docker][Docker]
![Maven][Maven]
![JUnit][JUnit]
![Swagger][Swagger]
![IntelliJ][IntelliJ]

</div>

---

# ✨ Funcionalidades

- 📚 Cadastro de livros
- ✍️ Cadastro de autores
- 🔍 Consulta de livros
- 🔍 Consulta de autores
- ✏️ Atualização de registros
- 🗑️ Exclusão de registros
- ✅ Validação de dados
- 📄 Respostas padronizadas
- ⚠️ Tratamento global de exceções
- 🐘 Persistência em PostgreSQL
- 📦 API REST

---

# 🏗️ Arquitetura

O projeto utiliza arquitetura em camadas para separar responsabilidades.

```
Controller
     │
     ▼
Service
     │
     ▼
Repository
     │
     ▼
PostgreSQL
```

Cada camada possui responsabilidades específicas:

- **Controller** → recebe as requisições HTTP.
- **Service** → implementa as regras de negócio.
- **Repository** → acesso ao banco de dados.
- **Model** → entidades da aplicação.
- **DTO** → comunicação entre API e cliente.
- **Mapper** → conversão entre entidades e DTOs.

---

# 📂 Estrutura

```
src
└── main
    ├── controller
    ├── dto
    ├── entity
    ├── exception
    ├── mapper
    ├── repository
    ├── service
    ├── config
    └── LibraryApiApplication
```

---

# 🗄️ Modelo de Domínio

Entidades principais:

- 📖 Book
- ✍️ Author

Relacionamentos entre entidades são gerenciados através do Spring Data JPA.

---

# 🌐 Endpoints

## Books

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | /books | Lista todos os livros |
| GET | /books/{id} | Busca um livro |
| POST | /books | Cria um livro |
| PUT | /books/{id} | Atualiza um livro |
| DELETE | /books/{id} | Remove um livro |

---

## Authors

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | /authors | Lista autores |
| GET | /authors/{id} | Busca um autor |
| POST | /authors | Cria um autor |
| PUT | /authors/{id} | Atualiza um autor |
| DELETE | /authors/{id} | Remove um autor |

---

# 🚀 Executando

## Pré-requisitos

- Java 21+
- Maven
- PostgreSQL

Clone o projeto

```bash
git clone https://github.com/MattheusMorais/library-api.git
```

Entre na pasta

```bash
cd library-api
```

Execute

```bash
mvn spring-boot:run
```

---

## Docker

Caso utilize Docker Compose:

```bash
docker compose up
```

---

# 🧪 Testes

Execute os testes com:

```bash
mvn test
```

Os testes validam regras de negócio, serviços e componentes da aplicação.

---

# 📌 Conceitos Aplicados

- Spring Boot
- Spring Data JPA
- RESTful APIs
- DTO Pattern
- Repository Pattern
- Dependency Injection
- Exception Handling
- Bean Validation
- Layered Architecture
- SOLID
- Clean Code

---

# 🚧 Roadmap

- [ ] Spring Security
- [ ] JWT Authentication
- [ ] Swagger/OpenAPI
- [ ] Testcontainers
- [ ] Docker Compose
- [ ] Flyway
- [ ] Paginação
- [ ] Filtros
- [ ] Busca por critérios
- [ ] CI/CD com GitHub Actions

---

# 📄 Licença

Distribuído sob a licença MIT.

Veja `LICENSE` para mais informações.

---

# 🤝 Contato

**Matheus Morais**

LinkedIn:
https://www.linkedin.com/in/mattheus-morais/

Email:
moraism.dev@gmail.com

Projeto:
https://github.com/MattheusMorais/library-api

Site:
https://matheus-morais.vercel.app

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

---

## Badges

```md
[issues-shield]: https://img.shields.io/github/issues/MattheusMorais/library-api.svg?style=for-the-badge
[issues-url]: https://github.com/MattheusMorais/library-api/issues

[license-shield]: https://img.shields.io/github/license/MattheusMorais/library-api.svg?style=for-the-badge
[license-url]: https://github.com/MattheusMorais/library-api/blob/main/LICENSE

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/mattheus-morais/

[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white

[SpringBoot]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white

[SpringData]: https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge

[PostgreSQL]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white

[Docker]: https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white

[Maven]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white

[JUnit]: https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white

[Swagger]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black

[IntelliJ]: https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white
```
