# 🎓 API de Gestão de Matrículas de Alunos

Esta é uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciamento de **alunos, disciplinas e matrículas**, permitindo cadastro, consulta de histórico e controle de notas.

---

## 📚 Funcionalidades

- ✅ Cadastro de alunos
- ✅ Cadastro de disciplinas
- ✅ Matrícula de alunos em disciplinas
- ✅ Lançamento de notas
- ✅ Geração de histórico escolar do aluno
- ✅ Cálculo de média e status (Aprovado/Reprovado)

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL (ou o banco que estiver usando)
- Lombok
- DBeaver (para gerenciar o banco)

---

## 🚀 Como executar o projeto

### Pré-requisitos

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) (ou outro banco compatível)
- [DBeaver](https://dbeaver.io/) (opcional, para visualizar o banco)

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2. Configure no Banco de Dados

No arquivo **src/main/resources/application.properties**:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/alunosdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

💡 Você também pode importar o arquivo dump.sql localizado em src/main/resources/db/dump.sql para popular o banco com dados.

### 3. Execute a aplicação

```bash
./mvnw spring-boot:run
```

💡 Também pode ser executado pelo main.java

A API será executada em: http://localhost:8080

---

## 🧠 Organização do Projeto

<pre><code>src/
  ├── main/ 
  │ ├── java/ 
  │ │     └── br/ 
  │ │        └── com/ 
  │ │             └── alunoonline/ 
  │ │                       └── api/ 
  │ │                            ├── controller/ 
  │ │                            ├── service/
  │ │                            ├── repository/ 
  │ │                            ├── model/  
  │ │                            └── dto/ 
  │ └── resources/ 
  │     ├── application.properties        # Configuração da aplicação 
  │     ├──  db/ 
  │     │      └── dump.sql # Backup do banco de dados
  │     └── insomnia
  │            └── Insomnia_2025-05-27.yaml # Collection do Insomnia
  └── test/ </code></pre>
