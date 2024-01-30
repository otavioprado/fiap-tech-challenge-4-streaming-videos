# Streaming de Vídeos

## Descrição

Streaming de Vídeos é um projeto de streaming de vídeos que permite gerenciar vídeos de forma eficiente.

## Arquitetura

A aplicação é construída usando a seguinte arquitetura:

- **Frameworks**:
  - Spring Boot 3.1.5 .
  - Java 21.
  - Spring WebFlux 3.1.5 para expor endpoints reativos.
  - Spring Data 3.1.5 para persistência com MongoDB.
  - Docker Desktop para execução do container do MongoDB.
- **Banco de Dados**: 
  - MongoDB.

## Decisões Técnicas Relevantes

- **Java e Spring Boot**: Escolhemos Java e Spring Boot devido à sua eficiência, robustez e facilidade de desenvolvimento para criar uma aplicação de streaming de vídeos escalável.
- **MongoDB**: Selecionamos o MongoDB devido à sua flexibilidade de esquema e escalabilidade horizontal, o que é crucial para armazenar metadados de vídeo.
- **Autenticação**: Não implementado: Decidimos não implementar a autenticação pelo motivo de ja termos realizado em TechChallenges anteriores, entendemos a partir material de requisitos, que não ficou obrigatório o desenvolvimento. Porém, poderiamos ter utilizado o Spring Security com JWT e armazenar as informações de catálogo favorito persistindo em banco de dados.

### Tecnologias Utilizadas no Projeto

- Java 21
- Spring Boot 3.1.5
- Docker
- MongoDB
- Springdoc OpenAPI WebFlux
- MapStruct
- Lombok

## Guia de Uso

### Pré-requisitos

- Certifique-se de ter os softwares abaixo em sua máquina:
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
O Swagger estará disponível em http://localhost:8080/webjars/swagger-ui/index.html no seu navegador
## Requisitos Funcionais
- Criação, atualização, listagem e exclusão de vídeos.
- Os vídeos devem conter os seguintes campos: título, descrição, URL e data de
   publicação.
- A listagem de vídeos deve ser paginada e ordenável por data de publicação.
- Implementar filtros de busca por título e data de publicação na listagem.
- Implementar sistema de marcação de vídeos como favoritos.
-  Implementar categorias para os vídeos e permitir a filtragem por categoria na
   listagem.
- Implementar um sistema de recomendação de vídeos com base nos favoritos do
   usuário.
- Implementar um endpoint para estatísticas, mostrando a quantidade total de vídeos,
   a quantidade de vídeos favoritados e a média de visualizações.
## Requisitos Técnicos
- Utilização do Spring WebFlux para a criação de endpoints reativos.
- Utilização do Spring Boot para configuração e inicialização da aplicação.
- Utilização do Spring Data para a camada de persistência com suporte a bancos de
   dados reativos (por exemplo, MongoDB).
- Implementar a arquitetura Clean Architecture, separando a aplicação em camadas:
   Controllers, Services, Use Cases, Repositories.
- Implementar testes unitários e de integração para as diferentes camadas da
   aplicação, com cobertura de testes de pelo menos 80% do código.
- Utilizar boas práticas de nomenclatura, organização de código e comentários quando
   necessário.
- Utilizar validações de entrada nos endpoints.
- Gerenciar dependências utilizando o gerenciador de pacotes Maven ou Gradle.

# Contribuindo
Fique à vontade para contribuir para este projeto. Basta fazer um fork e enviar suas solicitações.

# Base de categoria
Obtida via https://pt.wikipedia.org/wiki/Lista_de_g%C3%AAneros_cinematogr%C3%A1ficos
