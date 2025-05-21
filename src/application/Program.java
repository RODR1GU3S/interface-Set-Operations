package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));

				set.add(new LogEntry(username, moment));

				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
/*     >>>>>               **Operações de Conjunto (Set Operations)**                    <<<<<

       >>>>>     São operações que **lidam com múltiplos elementos ao mesmo tempo**,     <<<<<
       >>>>>              baseadas na **teoria dos conjuntos matemáticos**.              <<<<<


## ✅ 2. **Operações de Conjunto (Set Operations)**

Elas fazem sentido especialmente em tipos como `Set`, mas também são suportadas pela interface `Collection`.

### 📌 Tipos principais:

1. **União** (`addAll`): combina todos os elementos de duas coleções.

   set1.addAll(set2); // união: tudo de set1 + set2, sem duplicação

   ```

2. **Interseção** (`retainAll`): mantém apenas os elementos que existem **em ambas** as coleções.

   set1.retainAll(set2); // interseção: só os elementos comuns

   ```

3. **Diferença** (`removeAll`): remove do conjunto atual os elementos que também existem no outro.

   set1.removeAll(set2); // diferença: remove os que set1 e set2 têm em comum

   ```

4. **Contém todos** (`containsAll`): verifica se todos os elementos de um conjunto estão em outro.

   set1.containsAll(set2); // verdadeiro se set1 contém todos os de set2

   ```

---

Esse programa é um ótimo exemplo prático de uso da interface `Set` em Java.
 De acordo com *The Java™ Tutorials*,
  alguns pontos importantes podem ser destacados e explicados para compreender o que esse código ensina sobre a interface `Set`:

---

### 📌 **1. Interface Set e Implementação HashSet**

```java
Set<LogEntry> set = new HashSet<>();
```

* `Set` é uma **interface** da Java Collections Framework que representa um conjunto **sem elementos duplicados**.
* `HashSet` é uma das implementações mais comuns de `Set`, baseada em uma tabela de espalhamento (hash table). Ela oferece **operações constantes de tempo esperado** para `add`, `remove`, `contains`, e `size`, desde que o hash esteja bem distribuído.
* O uso de `Set` é ideal aqui porque o objetivo é **contar usuários únicos**.

---

### 📌 **2. Detecção de duplicatas com `hashCode()` e `equals()`**

```java
@Override
public int hashCode() {
	return Objects.hash(username);
}

@Override
public boolean equals(Object obj) {
	...
	return Objects.equals(username, other.username);
}
```

* O comportamento de um `Set` depende diretamente dos métodos `hashCode()` e `equals()` dos objetos armazenados.
* Aqui, dois objetos `LogEntry` são considerados iguais se tiverem o **mesmo nome de usuário**, independentemente da data.
* Isso garante que usuários duplicados **(mesmo nome)** sejam armazenados **apenas uma vez**.

---

### 📌 **3. Aplicação prática: filtrando elementos únicos**

```java
set.add(new LogEntry(username, moment));
```

* Cada linha do arquivo representa um acesso de usuário com data/hora.
* Ao inserir no `Set`, acessos duplicados por um mesmo usuário são ignorados (por causa do `equals`/`hashCode`).
* Ao final, `set.size()` retorna o **total de usuários únicos**, conforme o critério de unicidade definido.

---

### 📌 **4. Uso do Set como estrutura de verificação**

* Um dos principais usos do `Set` é **verificar presença/ausência** e **evitar duplicatas** automaticamente.
* Isso evita a necessidade de realizar buscas manuais para checar se um elemento já foi adicionado, otimizando o código.

---

### 📌 **5. Boas práticas com Generics**

```java
Set<LogEntry> set = new HashSet<>();
```

* O uso de generics (`<LogEntry>`) fornece **verificação de tipo em tempo de compilação**, evitando `ClassCastException`.
* Também torna o código mais legível e seguro.

---

### 📌 **Outros aspectos importantes mostrados indiretamente**

* **Try-with-resources** para fechar automaticamente o `BufferedReader`.
* **Leitura de arquivo linha por linha**.
* **Uso de `Instant` e `Date.from()`** para conversão de data/hora ISO-8601.

---

### ✅ Conclusão

Esse exemplo ilustra de forma clara o poder do `Set` para resolver problemas de unicidade com elegância e eficiência. Ele se alinha diretamente com os princípios mostrados em *The Java™ Tutorials*, especialmente:

* [Lesson: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
* [Lesson: Collections - Set Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html)

*/