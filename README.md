# api-sicredi

# Sistema de Votação Cooperativa

Este é um projeto Spring Boot que fornece uma API REST para gerenciar e participar de sessões de votação cooperativa.

## Funcionalidades

- Cadastrar uma nova pauta
- Abrir uma sessão de votação em uma pauta
- Receber votos dos associados em pautas
- Contabilizar os votos e dar o resultado da votação na pauta

## Pré-requisitos

- Java 17
- Maven

## CLONAR O REPOSITORIO DO GIT EM SEU COMPUTADOR

`git clone <https://github.com/Tiagosantos056/api-sicredi.git >`.

## ACESSE A PASTA POR NOME `api-sicredi`
``
cd api-sicredi
``

## Construa o projeto com Maven
``
mvn clean install
``

## A aplicação agora deve estar rodando em http://localhost:8080

# Endpoints da API
* POST /pautas: Cria uma nova pauta
* POST /pautas/{id}/abrir-sessao: Abre uma sessão de votação para uma pauta existente
* POST /votos: Registra um novo voto
* GET /votos/{id}/contabilizar: Contabiliza os votos para uma pauta específica 

## Contribuindo
* Pull requests são bem-vindos. Para mudanças importantes, por favor, abra uma issue primeiro para discutir o que você gostaria de mudar.

* Por favor, certifique-se de atualizar os testes conforme apropriado.

# Licença
* MIT
