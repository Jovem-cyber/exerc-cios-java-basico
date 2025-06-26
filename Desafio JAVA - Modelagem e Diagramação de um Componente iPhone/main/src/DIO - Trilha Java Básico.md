
# DIO - Trilha Java Básico 

## Modelagem e Diagramação de um Componente iPhone

Aluno: [Guilherme Monteiro](https://github.com/Jovem-cyber)

Venho por meio deste apresentar o meu desafio cumprido conforme solicitado no [exercício](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/poo).

*Mencionando o techo que faz a solicitação:*

* Neste desafio, você será responsável por modelar e diagramar a representação UML do componente iPhone, abrangendo suas funcionalidades como Reprodutor Musical, Aparelho Telefônico e Navegador na Internet.

```mermaid
classDiagram

 iPhone --> ReprodutorMusical
    iPhone --> AparelhoTelefonico
    iPhone --> NavegadorInternet

    class NavegadorInternet {
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    class AparelhoTelefonico {
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }

    class ReprodutorMusical {
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
    }
       

