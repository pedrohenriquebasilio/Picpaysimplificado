
# PicPay Simplificado

## Descrição do Projeto

Este projeto é uma implementação de um **desafio técnico** inspirado nas funcionalidades do **PicPay**, voltado para o desenvolvimento de uma API de transações financeiras entre usuários. O foco principal é simular transações e validar suas permissões de acordo com regras específicas de negócio. Além disso, o projeto incorpora a integração com APIs externas para verificar a possibilidade de efetuar transações, tudo dentro de um ambiente de **Spring Boot**.

## Funcionalidades

- **Simulação de transações** entre usuários.
- **Integração com API externa** para validação de transações.
- Definição de **tipos de usuários** (por exemplo, cliente ou lojista) com permissões diferenciadas.
- **Tratamento de erros** para garantir a integridade e segurança dos dados.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Maven** para gerenciamento de dependências.
- **APIs REST** para integração com serviços externos.
- **Banco de Dados Relacional** (futuramente: MySQL).
- **Tratamento de Exceções** personalizado.

## Como Configurar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/pedrohenriquebasilio/Picpaysimplificado.git
   cd Picpaysimplificado
   ```

3. **Executar o Projeto**:
   - Use o Maven para construir e rodar a aplicação:
     ```bash
     mvn spring-boot:run
     ```

## Melhorias Futuras

- **Persistência com MySQL**: Atualmente, os dados são simulados em memória. Uma das próximas implementações será o suporte a um banco de dados relacional para persistência de dados.
- **Testes Unitários**: Serão adicionados para garantir a cobertura e integridade do código.

## Como Contribuir

1. Faça um **fork** do projeto.
2. Crie uma nova branch para suas alterações:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça o commit das suas alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie as alterações para o repositório:
   ```bash
   git push origin minha-feature
   ```
5. Abra um **Pull Request**.
