# Projeto CRUD de usuários em Java

Este projeto é um exemplo de um aplicativo Java que realiza operações CRUD (criar, ler, atualizar e excluir) em uma tabela de usuários em um banco de dados relacional.

## Configuração do banco de dados

Antes de executar o aplicativo, é necessário configurar as variáveis de ambiente para o URL do banco de dados, nome de usuário e senha. Para fazer isso, crie um arquivo `.env` na raiz do projeto e defina as seguintes variáveis:

```
DB_URL=jdbc:<database-driver>://<database-local>/<database-name>
DB_USERNAME=
DB_PASSWORD=
```

Substitua `<database-driver>` pelo driver JDBC para o seu banco de dados (por exemplo, `mysql` ou `postgresql`), `<database-local>` pelo endereço do servidor do banco de dados (por exemplo, `localhost`), `<database-name>` pelo nome do banco de dados e deixe `DB_USERNAME` e `DB_PASSWORD` em branco.

## Executando o aplicativo

Após configurar as variáveis de ambiente, você pode executar o aplicativo usando o Maven. Navegue até a raiz do projeto e execute o seguinte comando:

` mvn spring-boot:run`

Isso irá compilar o projeto e executá-lo em um servidor embutido. Você pode acessar o aplicativo em `http://localhost:8080/`.

## Endpoints da API

O aplicativo expõe os seguintes endpoints da API para operações CRUD:

- `GET /users/`: retorna todos os usuários cadastrados.
- `GET /users/{id}`: retorna um usuário específico pelo ID.
- `POST /users`: cria um novo usuário com base nos dados fornecidos no corpo da solicitação.
- `PUT /users/{id}`: atualiza um usuário existente com base no ID e nos dados fornecidos no corpo da solicitação.
- `DELETE /users/{id}`: exclui um usuário existente com base no ID.

Para obter mais informações sobre como usar esses endpoints, consulte a documentação da API incluída no projeto.
