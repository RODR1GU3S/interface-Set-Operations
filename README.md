# Interface Set e implementação HashSet

Este projeto em Java tem como objetivo demonstrar o uso da interface `Set` para identificar **usuários únicos** que acessaram um sistema,
 com base em registros de log lidos a partir de um arquivo.
A identificação única dos usuários é feita por meio da sobrescrição dos métodos `equals` e `hashCode` na classe `LogEntry`.

## 📋 Descrição

O programa lê um arquivo de log contendo registros no seguinte formato:

```
usuario1 2025-05-21T15:21:32Z
usuario2 2025-05-21T16:02:45Z
usuario1 2025-05-21T17:10:10Z
```

Cada linha representa o nome de usuário e o momento do acesso ao sistema.
 O programa processa essas informações para contar quantos usuários distintos acessaram a aplicação.

## 💡 Funcionalidades

* Leitura de arquivos com registros de acesso.
* Armazenamento dos dados em um `HashSet` para garantir unicidade.
* Contagem do número total de usuários únicos.

## 🛠️ Tecnologias utilizadas

* Java SE
* Interface `Set` e implementação `HashSet`
* Manipulação de datas com `Instant` e `Date`
* Leitura de arquivos com `BufferedReader`

## 📁 Estrutura do projeto

```plaintext
src/
├── application/
│   └── Program.java
├── entities/
│   └── LogEntry.java
```

## ▶️ Como executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Compile os arquivos `.java`:

   ```bash
   javac application/Program.java entities/LogEntry.java
   ```
3. Execute o programa:

   ```bash
   java application.Program
   ```
4. Insira o caminho completo para o arquivo de log quando solicitado.

## ✅ Exemplo de saída

```
Enter file full path: logs.txt
Total users: 2
```

## 📌 Observações

* A classe `LogEntry` considera apenas o nome do usuário para definir igualdade (`equals` e `hashCode`), ou seja, acessos múltiplos do mesmo usuário são contados apenas uma vez.
* Certifique-se de que o arquivo de log está no formato correto (`username dataISO`), por exemplo: `joao 2025-05-21T17:10:10Z`.
```
