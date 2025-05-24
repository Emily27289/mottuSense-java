# MottuSense API – Solução Inteligente para Gestão de Pátios

Este repositório contém a API Java desenvolvida para o Challenge da FIAP. A aplicação tem como objetivo gerenciar motos no pátio da empresa Mottu, organizando setores, vagas, status de manutenção e fotos das motos. A solução foi pensada para ser integrada com sensores e outros módulos como uma API .NET, oferecendo uma abordagem moderna e eficiente.

 **[Link para o repositório público no GitHub](https://github.com/Emily27289/mottuSense-java.git)**

---

## Equipe
- Gabriela Gomes Cezar - rm556941
- Emily Maria de Oliveira Macedo - rm554882
- Felipe de Santana Santos - rm558916

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- Bean Validation
- Swagger (SpringDoc OpenAPI)
- Maven
- Banco de dados Oracle (ou H2 para testes)

---

## Funcionalidades da API

- Cadastro de motos com status, urgência e relação com vaga
- Registro de setores e vagas
- Associação de vagas a setores e motos a vagas
- Upload de fotos de motos
- Filtros por status e urgência
- Paginação e ordenação
- Uso de DTOs para entrada e saída
- Validação de campos
- Cache de resultados
- Tratamento centralizado de erros

---

## Como Executar o Projeto

### Pré-requisitos:
- Java 21 instalado
- Maven instalado ou uso do wrapper (`mvnw`)
- Banco Oracle rodando (ou altere para H2 no `application.properties`)

### Passos:

```bash
# Clone o repositório
git clone https://github.com/Emily27289/mottuSense-java.git

# Acesse a pasta
cd mottuSense-java

# Execute o projeto
./mvnw spring-boot:run
