# City Denúncia

Sistema web para registro e acompanhamento de denúncias urbanas desenvolvido em Java com Spring Boot.

## Tecnologias utilizadas

```bash
- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- Maven
- H2 Database
- HTML/CSS
- CSS3
```

## Funcionalidades

Usuários

```bash
- Cadastro de usuários
- Login de usuários
- Validação de e-mail duplicado
- Persistência em banco de dados
```

Denúncias

```bash
- Cadastro de denúncias
- Listagem de denúncias
- Status automático ("ABERTA")
- Registro automático da data de criação
```

Interface

```bash
- Página inicial
- Tela de login
- Tela de cadastro
- Tela de denúncia
- Navegação entre páginas
```

Backend

```bash
- Arquitetura em camadas
Controller
Service
Repository
Model
- Integração com banco H2
- API REST para integração com frontend
```

## Estrutura do projeto

```bash
src/main/java
├── controller
├── model
├── repository
├── service

src/main/resources
├── templates
├── static
```

## Endpoints Disponíveis

Cadastro de Usuário

```bash
POST /usuarios

Exemplo:

{
  "nome": "Jose",
  "email": "jose@email.com",
  "senha": "123456"
}
```

Login

```bash
POST /usuarios/login

Exemplo:

{
  "email": "tadeu@email.com",
  "senha": "123456"
}
```

Cadastro de Denúncia

```bash
POST /denuncias

Exemplo:

{
  "titulo": "Buraco na rua",
  "categoria": "Infraestrutura",
  "bairro": "Centro",
  "endereco": "Rua das Flores",
  "descricao": "Buraco grande causando acidentes",
  "imagem": "foto.jpg"
}
```

Listagem de Denúncias

```bash
GET /denuncias
```

## Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto no IntelliJ IDEA.

3. Execute:

```bash
ProjetoCityDenunciaApplication.java
```

4. Acesse:

```bash
http://localhost:8080
```
## Banco H2

Console H2:

```bash
http://localhost:8080/h2-console

Configuração padrão:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Senha:
```


## Status

```bash
🚧 Projeto acadêmico em desenvolvimento.
✅ Backend funcional para cadastro e consulta de usuários e denúncias.
🚧 Frontend principal em desenvolvimento pela equipe do projeto.
```
