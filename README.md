# 🥷 Cadastro de Ninjas

Uma API RESTful desenvolvida em Java com Spring Boot para gerenciar o cadastro de ninjas, incluindo suas habilidades, missões e classificações. O projeto utiliza práticas modernas de desenvolvimento, como o uso de DTOs para encapsulamento de dados, JPA para mapeamento objeto-relacional e validação de dados com Bean Validation.

## 🚀 Tecnologias Utilizadas

- **Java 17**: Linguagem principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para mapeamento objeto-relacional.
- **Hibernate Validator (Bean Validation)**: Para validação de dados.
- **Maven**: Gerenciador de dependências e build.
- **Banco de Dados**: PostgreSQL via Docker.
- **Docker & Docker Compose**: Para containerização e orquestração do ambiente de banco de dados.


## 📌 Funcionalidades

- **Cadastro de Ninjas**: Permite adicionar novos ninjas ao sistema.
- **Gerenciamento de Habilidades**: Associação de habilidades específicas a cada ninja.
- **Atribuição de Missões**: Designação de missões para os ninjas.
- **Classificação de Ninjas**: Categorização dos ninjas com base em critérios específicos.
- **Validação de Dados**: Garantia de integridade dos dados inseridos no sistema.

## 🔗 Relacionamento entre Tabelas

O projeto utiliza JPA para mapear as entidades do domínio e definir os relacionamentos entre as tabelas do banco de dados. Os principais relacionamentos são:

- **Ninja ↔ Habilidade**
  - Relacionamento **Many-to-Many**
  - Um ninja pode possuir várias habilidades, e uma habilidade pode pertencer a vários ninjas.

- **Ninja ↔ Missão**
  - Relacionamento **One-to-Many**
  - Um ninja pode ser designado para várias missões, mas cada missão é atribuída a um único ninja.

- **Ninja ↔ Classificação**
  - Relacionamento **Many-to-One**
  - Vários ninjas podem compartilhar a mesma classificação.

## 📂 Uso de DTOs

Para proteger as entidades e controlar os dados expostos nas requisições e respostas da API, o projeto utiliza DTOs (Data Transfer Objects). Isso permite:

- **Encapsulamento de Dados**: Exposição apenas dos campos necessários.
- **Validação de Entrada**: Aplicação de regras de validação específicas para cada operação.
- **Conversão entre Entidades e DTOs**: Facilita a transformação de dados entre as camadas da aplicação.


