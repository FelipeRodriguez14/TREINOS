# 📚 Sistema de Gerenciamento de Biblioteca (Java)

Este é um projeto desenvolvido para consolidar os fundamentos de **Lógica de Programação** e **Programação Orientada a Objetos (POO)**. O sistema simula as operações essenciais de uma biblioteca, permitindo diferentes níveis de acesso e controle de dados.

## 🚀 Tecnologias e Conceitos Aplicados

O projeto abrange uma trilha completa de aprendizado inicial em Java:

* **Lógica de Programação:** Estruturas condicionais (`if/else`) e de repetição (`for`, `while`).
* **POO:** Uso de encapsulamento, classes, objetos e métodos.
* **Gestão de Erros:** Criação e tratamento personalizado de exceções e uso de alertas via `JOptionPane`.
* **Arquitetura:** Organização em pacotes (Entitys, Services, Exceptions).
* **CRUD:** Operações de Criação, Leitura, Atualização e Deleção de registros.

---

## 🏛️ Estrutura do Projeto

O sistema foi organizado para separar as responsabilidades de negócio da interface com o usuário:

### 📦 Pacotes Principais
* **Entities:** Representação dos objetos do sistema (Livros, Usuários).
* **Services:** Gerenciamento das listas de dados.
* **Exceptions:** Exceções customizadas para regras específicas.

### 🎮 Fluxo de Menus
Para facilitar a navegação, a interface foi dividida em camadas:
1.  **MainIniciar:** Ponto de entrada para escolha do tipo de login.
2.  **MainAdmin:** Painel de controle do administrador com permissões totais para gerenciamento.
3.  **MainUser:** Interface simplificada para usuários comuns.
4.  **MenuServices:** Classe controladora responsável por gerenciar a exibição dos menus acima.

---

## 📝 Notas de Desenvolvimento

* **Banco de dados:** Nesse projeto eu não utilizei nenhum banco de dados. Eu apenas iniciei e alimentei um List, que por padrão, já possui alguns livros e usuários cadastrados. Você pode observar que tem alguns livros que possuem o mesmo valor de atributo, utilizei para teste. Mas você também pode alimentar manualmente, como preferir. Nos passos `COMO EXECUTAR ` que segue a baixo, explica como fazer. 

* **Refatoração:** Alguns métodos possuem lógicas estendidas para fins didáticos e estão abertos a melhorias. Sinta - se a vontade para trabalhar com esse código.

* **Interface:** Você pode perceber que em alguns casos, em vez de utilizar as minhas classes personalizadas de **Exceptions** Optei pelo uso de `JOptionPane` para garantir um tratamento de erros visual e direto, mantendo o código focado na lógica de POO sem excesso de complexidade técnica, com o intuito apenas de demonstrar para o usuário o que está causando erro no sistema.

* **Nomenclatura:** A classe `MenuServices` possui métodos com nomes similares aos menus principais; esta é uma observação documentada para futuras refatorações de organização, pois pode gerar confusçoes para entender o código.

**CÓDIGO DESENVOLVIDO NO VSCODE**

**COMENTÁRIO**
`Me recordo que em minhas aulas no curso de informática, sempre víamos lógica de programação de uma maneira mais rasa, sempre resolvendo questões sobre identificação de triângulos, operações com números, verificações de números ímpares e pares e outros exercícios básicos. Hoje, decide colocar em prática de uma maneira diferente, apliquei todos os conceitos de POO e lógica que já estudei para desenvolver um pequeno sistema de uma biblioteca. Um sistema simples, sem frameworks, sem API´S, sem banco de dados e sem nenhum outro recurso externo, somente eu, minha lógica e o Java. Por isso, alguns trechos podem ter ficado confusos, pois na medida em que eu ia pensando em como resolver o problema desse sistema, eu aplicava, para não esquecer a lógica, e se desse certo eu deixava da mesma forma, sem prezar 100% pela estrutura ou aprimoramento de código. Por isso afirmo mais uma vez, que o projeto é simples, tem alguns erro que eu sei que existem e aqueles que eu ainda não descobri, tentei manter o máximo de comentários possível. Mas, caso tenha dúvidas de como rodar o projeto para poder entender, me chamem nas redes sociais. Ótimo estudos dev !!!!`

---

## 🛠️ Como Executar

1. Clone o repositório.
2. Certifique-se de ter o JDK instalado.
3. No seu terminal, utilizando o comando CD, vá até a pasta main. Nela contém a classe principal.

4. Para se cadastrar no sistema você pode ir até o arquivo UserService.java em `TREINOS / biblioteca / service / UserService.java` e cadastrar manualmente seu próprio usuário, dentro do método initStock. Se preferir copie e cole essa estrutura:

`usuarios.add(new User (4, "seu nome","senha", true));` para você se cadastrar como administrador. Caso deseje se cadastrar como usuário comum, apenas troque o "true" para false.

Você também pode fazer o mesmo para os livros. Você pode cadastrar manualmente os livros, indo até `TREINOS / bilbioteca/ service / LibraryService.java` e incluindo a estutura abaixo dentro do método initStock:

`livros.add(new Livro("Nome do livro", "Autor", true, preço));`

OBS: Depois de logar como administrador(a), você pode incluir usuários e livros dentro do menu adequado.

5. Execute a classe de entrada principal (Main).