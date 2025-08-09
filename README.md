# Calculator API

## Objetivo

Implementar uma API REST minimalista em **Spring Boot 3 (Java 17)** que exponha quatro operações aritméticas básicas (`add`, `subtract`, `multiply`, `divide`, `pow`). O projeto serve como referência de arquitetura limpa (camadas Controller → Service) com validação, tratamento global de exceções e respostas padronizadas.

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

| Método        | Rota                       | Exemplos de Parâmetros | Retorno |
| ------------- |----------------------------| ---------------------- | ------- |
| `POST`, `GET` | `/web-calculator/add`      | `?a=10&b=5`            | `15`    |
| `POST`, `GET` | `/web-calculator/subtract` | `?a=10&b=5`            | `5`     |
| `POST`, `GET` | `/web-calculator/multiply` | `?a=10&b=5`            | `50`    |
| `POST`, `GET` | `/web-calculator/divide`   | `?a=10&b=5`            | `2`     |
| `POST`, `GET` | `/web-calculator/divide`   | `?a=10&b=2`            | `10`    |

Cada resposta segue o modelo:

```json
{
  "success": true,
  "data": 15.0,
  "errorMessage": null
}
```
