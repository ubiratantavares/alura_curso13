# Plataforma Online: Alura

## Curso: Java: persistência de dados e consultas com Spring Data JPA

### 1. Evoluindo o projeto ScreenMatch

* Apresentação

Vídeo-aula

* Projeto inicial do curso

Neste curso vamos trabalhar com o mesmo projeto já finalizado do curso anterior, mas com algumas alterações no menu. Caso queira conferir as alterações ou começar por aqui, pode baixar o [projeto no GitHub](https://github.com/alura-cursos/3355-java-screenmatch-com-jpa)

* Evoluindo nossa aplicação Java

Vídeo-aula

* Desafio: adicionando mais propriedades à série

Nossa classe DadosSerie não está refletindo muito bem todas as informações que queremos buscar e armazenar na nossa aplicação. Já que iremos gravar séries no banco, é ideal que ela descreva mais os dados, tendo mais atributos. Por isso, te desafiamos a incrementar a busca e adicionar dados como: **Gênero**; **Atores**; **Pôster**; **Sinopse**. Propomos que você faça o mapeamento e rode a aplicação novamente. Verifique se todos os dados foram salvos corretamente.

* Método utilizado no enum categoria

No vídeo a seguir, precisaremos de criar um Enum e utilizar um método específico para fazer a conversão entre as informações do OMDB e as da nossa aplicação. Você pode copiar o código a seguir para conseguir prosseguir:

```java
public static Categoria fromString(String text) {
    for (Categoria categoria : Categoria.values()) {
        if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
            return categoria;
        }
    }
    throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
}
```

* Modelando categorias e séries

Vídeo-aula

* Para saber mais: um tipo diferente de modelar dados

Anteriormente, utilizamos um novo tipo de representação de dados, o Enum.

Enum é uma abreviação de "enumerados" e é um tipo especial de classe em Java que tem um número fixo de constantes. Empregar um Enum pode ser muito útil na programação para armazenar valores que sabemos que nunca vão mudar, como os dias da semana ou as fases da lua.

Vamos começar criando nosso próprio Enum? Imagine que estamos construindo um aplicativo sobre o sistema solar, e queremos um Enum para os planetas.

A seguir, um exemplo de como você poderia implementar isso:

```java
public enum Planetas {
    MERCURIO, 
    VENUS, 
    TERRA, 
    MARTE, 
    JUPITER, 
    SATURNO, 
    URANO, 
    NEPTUNO
}
```

Como você pode ver, um Enum em Java é muito semelhante a uma classe. No entanto, em vez de usar a palavra chave 'class', usamos 'enum'. Também devemos representar as constantes, que são separadas por vírgula e todas maiúsculas..

Agora que criamos nosso Enum, podemos começar a usá-lo em nosso código. No exemplo abaixo, definimos um método que recebe um planeta como argumento e imprime uma mensagem. Confira:

```java
public void qualPlaneta(Planetas planeta) {
    switch (planeta) {
        case TERRA:
            System.out.println("Você está na Terra!");
            break;
        default:
            System.out.println("Você não está na Terra!");
            break;
    }
}
```

Na função qualPlaneta, podemos passar qualquer um dos planetas definidos em nosso Enum. Se passarmos TERRA, a função imprimirá "Você está na Terra!", caso contrário, imprimirá "Você não está na Terra!".

Tratando Dados Categóricos

Um dos usos mais práticos de Enums é para tratar dados categóricos. Dados categóricos são tipos de dados que podem ser divididos em vários grupos ou categorias. A vantagem de usar Enums é que eles podem ajudar a garantir que só vamos usar os valores pré-definidos, prevenindo a ocorrência de erros.

Por exemplo, se estamos criando um aplicativo sobre animais e temos uma categoria chamada 'TipoAnimal', poderíamos usar um Enum para definir essa categoria:

```java
public enum TipoAnimal {
    MAMIFERO,
    REPTIL,
    AVE,
    PEIXE
}
```

Agora, em nosso código, só podemos escolher entre essas quatro opções quando definirmos um tipo de animal, tornando nosso código mais seguro e mais fácil de entender.

Então, para resumir: Enums em Java são uma maneira útil e eficaz de tratar informações estáticas e categóricas em nossos programas. Além disso, eles tornam nosso código mais seguro, visto que só permitimos os valores que já foram definidos no Enum, evitando erros ou confusões.

* Para saber mais: trabalhando com métodos estáticos

Em Java, um método estático é um método que pertence à classe e não a um objeto específico da classe. Traduzindo para uma linguagem mais simples: um método estático é aquele que pode ser usado mesmo que você não tenha criado nenhum objeto da classe.

Se você precisar de um método que não precisa interagir com os atributos ou outros métodos de um objeto, criar um método estático pode ser uma solução elegante e eficiente. Por exemplo, você poderia criar um método estático para calcular a média de um conjunto de números.

Além disso, os métodos estáticos são amplamente utilizados em bibliotecas auxiliares, como a classe Math e a classe Arrays do Java. Em vez de requerer que o usuário crie um objeto para usar os métodos, os métodos são estáticos, e assim podem ser acessados diretamente a partir da classe.

Como eu os utilizo em Java?

Vamos a um código de exemplo para entender isso melhor:

```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```

No código acima, temos um método estático "add" que soma dois números. Note que utilizamos a palavra-chave static para defini-lo. E como utilizamos ele? Aí vai:

```java
int result = MathUtils.add(5, 10);
```

Viu só? Não precisamos criar um objeto de MathUtils para usar o método "add".

Entender bem como funcionam os métodos estáticos em Java é de grande importância, pois eles permitem concretizar operações sem a necessidade de criar objetos e também são amplamente utilizados em bibliotecas do Java.

* Utilizando a classe mais completa

Vídeo-aula

* Classificando projetos do DEVSPOT

Sua missão como desenvolvedor no projeto DEVSPOT Portfolio é criar um sistema de classificação de projetos. Você decidiu que irá utilizar enums, dado que irá trabalhar com classificações: "Iniciante", "Intermediário" e "Avançado". Além disso, você quer associar uma pontuação para cada nível.

Como você implementaria esse Enum com os atributos para suportar essa funcionalidade?

```java
public enum Nivel {
    Iniciante(1), 
    Intermediario(2), 
    Avancado(3);
    
    private int pontuacao;
    Nivel(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
```

A pontuação é corretamente definida como um atributo para cada nível no enum. O enum tem um construtor que permite atribuir um valor a este atributo.

* Classe e dependência da OpenAI

Na sequência, iremos consumir a API do ChatGPT para trabalhar com a tradução da sinopse. Para isso, iremos utilizar a classe ConsultaChatGPT, no pacote service. O código da classe é o seguinte:

```java
package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("cole aqui sua chave da OpenAI");

        CompletionRequest requisicao = CompletionRequest.builder()
                                                        .model("gpt-3.5-turbo-instruct")
                                                        .prompt("traduza para o português o texto: " + texto)
                                                        .maxTokens(1000)
                                                        .temperature(0.7)
                                                        .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
```

Também precisaremos de adicionar uma dependência ao pom.xml:

```xml
<dependency>
    <groupId>com.theokanning.openai-gpt3-java</groupId>
    <artifactId>service</artifactId>
    <version>0.14.0</version>
</dependency>
```

* Usando o Chat GPT para traduzir a sinopse

Vídeo-aula

* Para saber mais: criando a conta no OpenAI

Para o desenvolvimento deste curso, vamos utilizar a API do ChatGPT e será necessário ter uma conta na plataforma da OpenAI, que distribui o serviço de geração de texto.

O ChatGPT é um programa de computador criado pela OpenAI que consegue entender e escrever texto em linguagem humana, como um chat ou conversa. É como um assistente virtual que responde às suas perguntas e ajuda em tarefas que envolvem palavras.

Então, vamos criar a conta no site do OpenAI?

1 - Para começar, vamos acessar o [site do OpenAI](https://openai.com/), onde vamos nos deparar com a seguinte tela...

E vamos clicar no botão "Get started".

2 - Logo após, seremos redirecionados a uma página de cadastro no site, que vai nos dar a opção de fazer cadastro utilizando o email, bem como com as contas Google, Microsoft ou Apple. Como mostrado abaixo...

Vamos preencher o campo de texto destinado ao email e clicar no botão "Continue".

3 - Uma vez que preenchemos o email, seremos redirecionados para a segunda parte do cadastro, onde vamos definir a senha da conta, como mostrado abaixo...

Para avançarmos, vamos definir uma senha segura, na caixa de texto "Password" e em seguida clicar no botão "Continue".

4 - Com isso, seremos redirecionados a uma página que nos avisa que a OpenAI enviará um email para confirmação da conta, para o endereço de email cadastrado previamente.

5 - Ao acessar o email cadastrado e abrir o email enviado pela OpenAI, vamos nos deparar com algo como mostrado abaixo...

Onde vamos clicar no botão "Verify email adress", para verificar o endereço de email.

6 - Após clicar no link, seremos novamente redirecionados para uma página de cadastro da OpenAI, onde são pedidas as informações: primeiro nome, sobrenome, organização (que é opcional) e data de nascimento, como mostrado...

Nessa tela, vamos preencher os nossos dados e clicar no botão "Continue".

7 - Em seguida, seremos redirecionados para uma página que pedirá a verificação pelo número de celular, similar à mostrada abaixo...

Nessa página, vamos escolher o país, que normalmente já vem pré-selecionado, e preencher o número de celular que receberá um SMS com o código de verificação do número. Após o preenchimento, podemos clicar no botão "Send Code".

8 - Por fim, vamos verificar a caixa de mensagens do celular com o número cadastrado, pois será enviado um código de confirmação, enquanto estamos sendo redirecionados para a página abaixo...

Onde vamos preencher o campo com o código recebido via celular.

E prontinho, o cadastro no site da OpenAI está criado e estamos prontos para seguir com o curso!

É importante lembrar que a OpenAI nos disponibiliza 5 dólares para utilizarmos em seu período de teste e que após a finalização desse período, ou ao término dessa cota gratuita, poderão ser efetuadas cobranças para o uso das ferramentas disponibilizadas pela empresa. Caso a sua cota tenha sido excedida, uma alternativa é criar outra conta da OpenAI, que também terá 5 dólares gratuitos.

* Faça como eu fiz: criando o menu do Screenmatch, adicionando informações

Agora é com você! Trabalhe na evolução do projeto Screenmatch: vamos modificar o menu, adicionar campos à classe DadosSerie e criar a sua classe personalizada Serie.

* O que aprendemos?

Nessa aula, você aprendeu como:

**Buscar várias séries na API**: Criamos um loop que encerra somente quando o usuário escolhe sair do menu, sendo capaz de buscar várias séries na API sem parar.

**Métodos privados**: Vimos que, se apenas uma classe irá acessar um método, não precisamos deixá-lo público, podemos declará-lo como privado. Isso é essencial para o encapsulamento das nossas classes.

**Adicionar mais informações aos dados buscados**: Revisamos como realizar o mapeamento entre atributos da API e atributos da nossa record.

**Converter os dados que vêm da API para a sua própria classe**: Criamos nossa própria classe Serie para representar melhor nossos dados. Para isso, foi necessário utilizar vários métodos de conversão.

**Utilizar um “ifreduzido”**: Utilizamos a classe OptionalDouble para lidar com valores decimais e seus possíveis erros, utilizando os métodos ofe orElse, que lembram muito o código de um if reduzido, e são muito úteis para evitar que ocorram Exceptions.

**Criar um Enum**: Percebemos que seria excelente poder categorizar nossas séries por gênero. Criamos um enum para isso, e vimos como criar métodos personalizados em enums.

**Consumir a API do ChatGPT**: Utilizamos a API do ChatGPT para traduzir nossos dados, adicionamos todas as dependências necessárias e configuramos a classe de consumo.

### 2. Persistindo os dados da série

* Projeto da aula anterior

* Instalação e configuração do Postgres

* Conectando ao banco relacional

* Para saber mais: diferentes tipos de bancos de dados

* Para saber mais: JPA e Hibernate

* Para saber mais: anotações do hibernate

* Mapeando as entidades

* Para saber mais: estratégias de geração do ID

* Anotações e mapeamento de entidades na prática

* Salvando dados no banco

* Para saber mais: criando variáveis de ambiente

* Deixando os dados sensíveis em segurança

* Faça como eu fiz: salvando séries no Postgres

* O que aprendemos?

### 3. Mapeando relacionamentos

* Projeto da aula anterior

* Relacionando séries e episódios

* Para saber mais: tipos de relacionamentos na JPA

* Aprofundando em relacionamentos bidirecionais

* Código do application.properties

* Para saber mais: relacionamentos Uni e Bidirecionais com JPA

* Salvando episódios da série

* Para saber mais: operações em cascata

* Ajustando a chave estrangeira

* Para saber mais: tipos de busca("eager" ou "lazy")

* Banco de dados no Bytebank

* Faça como eu fiz: relacionando séries e episódios

* O que aprendemos?

### 4. Buscando informações do banco

* 
