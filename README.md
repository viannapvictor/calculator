[![Build status](https://github.com/viannapvictor/devcalc-api/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/viannapvictor/devcalc-api/actions/workflows/ci.yml)

# Calculator API

## Objetivo

Implementar uma API REST minimalista em **Spring Boot 3 (Java 17)** que exponha quatro operações aritméticas básicas (`add`, `subtract`, `multiply`, `divide`). O projeto serve como referência de arquitetura limpa (camadas Controller → Service) com validação, tratamento global de exceções e respostas padronizadas.

## Tecnologia & Ferramenta de Build

| Camada          | Versão                              |
| --------------- | ----------------------------------- |
| **JDK**         | 17 ou superior                      |

## Como Executar Localmente

```bash
# 1. Clone o repositório
$ git clone https://github.com/viannapvictor/devcalc-api
$ cd calculator-api

# 2. Compile o projeto
$ mvn clean install

# 3. Execute a aplicação
$ mvn spring-boot:run                     # (modo dev – hot reload)
#   ou
$ java -jar target/calculator-*.jar

# 4. Acesse
http://localhost:8081
```

### Endpoints Disponíveis

| Método | Rota                       | Exemplos de Parâmetros | Retorno |
| ------ |----------------------------| ---------------------- | ------- |
| `POST` | `/web-calculator/add`      | `?a=10&b=5`            | `15`    |
| `POST` | `/web-calculator/subtract` | `?a=10&b=5`            | `5`     |
| `POST` | `/web-calculator/multiply` | `?a=10&b=5`            | `50`    |
| `POST` | `/web-calculator/divide`           | `?a=10&b=5`            | `2`     |

Cada resposta segue o modelo:

```json
{
  "success": true,
  "data": 15.0,
  "errorMessage": null
}
```

Em caso de erro de validação ou divisão por zero, `success` = false e `errorMessage` conterá a mensagem definida pelo enum `ErrorCode`.

#### Exemplo cURL

```bash
curl -X POST "http://localhost:8080/api/v1/add?a=10&b=5"
```

## Executando Testes

```bash
mvn test
```
```bash
## Teste para não rodar a action do CI
```

```bash
## Caso o workflow falhe, checar a falha pela interface do github em action e checar em qual ponto falhou corrigindo-o.
```

### Observações sobre a execução do pipeline

Realizei duas execuções do workflow **ci.yml**:  
• **Automática** (`event: push`) — disparada assim que fiz *push* no branch `master` dentro de arquivos no diretório src.  
• **Manual** (`event: workflow_dispatch`) — iniciada pelo botão **Run workflow** manualmente.
```
Percebi que o gatilho manual é ideal para diagnósticos rápidos ou quando quero testar apenas partes específicas do 
pipeline, enquanto o gatilho por push garante verificação contínua de cada commit. O badge de status no topo do 
README reflete sempre o resultado da execução mais recente, independentemente do gatilho utilizado.
```
