## 1. Diferença entre **workflows** e **actions**

```
Workflows são roteiros completos de automação que possuem muitas vezes várias actions. Por sua vez, actions são blocos 
reutilizáveis dentro desses roteiros como funções para um código que podem ser invocador e executar uma determinada ação.
```
---

## 2. Estrutura interna de uma **action**

```
As actions se estruturam da seguinte maneira, sempre teremos a entrada que será um script ou comando shell, os metadados 
obrigatórios que serão para invocar aquela action, e muitas vezes podemos definitir até os seu container de execução por
meio de Dockerfile. Ela se dividem ainda em ações de container (direcionamos as máquinas que irão rodar), ações compostas 
e javascript (rodadas em todas plataformas).

```
---
## 3. Papel do actio.yml
```
O arquivo action.yml é onde action é criada. Ele funciona dando diretrizes da action para os workflows que a consomem, especificando:

Entradas – todos os parâmetros que quem chama pode (ou deve) fornecer.

Saídas – valores computados que podem ser reutilizados por passos posteriores.

Execução – indica o que e como será executado (script Node, contêiner Docker ou sequência de passos compostos).

Sem esse arquivo o GitHub não reconhece a pasta como uma action válida; é nele que o runner descobre quais argumentos aceitar.
```
---
## 4. Exemplo prático ⤵️

### Action utilizada no projeto: `github/codeql-action` (init/analyze)

Trecho do workflow (`security_scan`):

```yaml
- name: Initialize CodeQL
  uses: github/codeql-action/init@v3
  with:
    languages: ${{ matrix.language }}
```

* **Chamada via `uses:`** – indica o repositório da action (`github/codeql-action`) e a versão fixa (`@v3`).
* **Parâmetros** – passados em `with:`; neste caso, `languages` é um *input* definido em seu `action.yml`.
* **Saídas** – etapas seguintes podem ler (`steps.<id>.outputs.<campo>`) se a action expõe algo. No caso de `codeql-action/analyze`, ela publica resultados direto em *Security → Code scanning alerts*.

---