# 💰 Expense Tracker

> API REST para controle de gastos pessoais.
> Java · Spring Boot · PostgreSQL

## 📋 Descrição

**Expense Tracker** é uma API REST construída com **Spring Boot 3** e **PostgreSQL** que permite registrar, consultar e analisar gastos pessoais. Os dados são persistidos em banco relacional via **JPA/Hibernate**, oferecendo consultas poderosas com **JPQL** e **Specifications**.

## ✨ Funcionalidades

- ❌ CRUD completo de gastos (REST)
- ❌ Filtro por categoria, período e valor
- ❌ Resumo de gastos agrupados por categoria
- ❌ Total de gastos no mês atual
- ❌ Paginação e ordenação nas listagens
- ❌ Validação de entrada com `Bean Validation`
- ❌ Tratamento de erros padronizado (`@ControllerAdvice`)
- ❌ Testes com **JUnit 5** + **MockMvc** + **Testcontainers**

## 🛠️ Stack

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 21 (LTS) | Linguagem principal |
| Spring Boot | 3.3+ | Framework |
| Spring Data JPA | — | ORM / Acesso a dados |
| PostgreSQL | 15+ | Banco de dados |
| Maven | 3.9+ | Build & dependências |
| Lombok | — | Redução de boilerplate |
| JUnit 5 + Testcontainers | — | Testes |

## 🚀 Como Executar

### Pré-requisitos

- JDK 21+
- Maven 3.9+
- PostgreSQL 15+ rodando localmente (ou Docker)

### Com Docker (recomendado)

```bash
# Sobe o PostgreSQL
docker run -d --name pg-expense \
  -e POSTGRES_DB=expense_tracker \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 postgres:15   