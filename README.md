# Streaming de Vídeos

## Descrição

Streaming de Vídeos é um projeto de streaming de vídeos que permite gerenciar vídeos de forma eficiente.

## Arquitetura

A aplicação é construída usando a seguinte arquitetura:

- **Backend**: Implementado em Java, utilizando o framework Spring Boot para criar APIs RESTful para gerenciar o catálogo de vídeos e usuários.
- **Banco de Dados**: Utilizamos o MongoDB para armazenar metadados de vídeos, informações de usuários e preferências.
- **Autenticação**: A autenticação é tratada usando JSON Web Tokens (JWT) para garantir a segurança das contas dos usuários.
- **Hospedagem**: O aplicativo e o banco de dados estão hospedados na AWS (Amazon Web Services) para garantir escalabilidade e alta disponibilidade do serviço de streaming.

## Decisões Técnicas Relevantes

- **Java e Spring Boot**: Escolhemos Java e Spring Boot devido à sua eficiência, robustez e facilidade de desenvolvimento para criar uma aplicação de streaming de vídeos escalável.
- **MongoDB**: Selecionamos o MongoDB devido à sua flexibilidade de esquema e escalabilidade horizontal, o que é crucial para armazenar metadados de vídeo.
- **JSON Web Tokens (JWT)**: Usamos JWT para autenticação, pois oferece uma maneira segura de gerenciar sessões de usuário sem a necessidade de armazenar senhas no banco de dados.
- **AWS**: A AWS nos fornece flexibilidade e escalabilidade, permitindo dimensionar nosso serviço de streaming de acordo com a demanda dos usuários.

### Tecnologias Utilizadas no Projeto

- Java 21
- Spring Boot 3.1.5
- Docker
- MongoDB
- JSON Web Tokens (JWT)
- Springdoc OpenAPI
- MapStruct
- Lombok

## Guia de Uso

### Pré-requisitos

- Certifique-se de ter os softwares abaixo em sua máquida:
    - Java 21.
    - Docker.
    - mvn.

### Configuração

Clone este repositório:

```bash
git clone https://github.com/seu-usuario/streaming-de-videos.git
```
Navegue para o diretório da aplicação:

````bash
cd streaming-de-videos
````
Inicie o mongo-db via docker:
````bash
docker compose up -d
````
Inicie a app:
````bash
mvn spring-boot:run
````
A aplicação estará disponível em http://localhost:8080 no seu navegador.

## Funcionalidades
* Navegação de catálogo de vídeos.
* Adicione vídeos à sua lista de favoritos.
* Consulte o histórico de exibição.

# Contribuindo
Fique à vontade para contribuir para este projeto. Basta fazer um fork e enviar suas solicitações.

# Base de categoria
Obtida via https://pt.wikipedia.org/wiki/Lista_de_g%C3%AAneros_cinematogr%C3%A1ficos