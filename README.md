
# PicPay Simplificado - API de Pagamentos

Bem-vindo ao repositório do **PicPay Simplificado**! Este projeto foi desenvolvido como parte de um desafio técnico, inspirado no desafio de backend do PicPay, com o objetivo de criar uma **API REST** para gerenciamento de usuários, carteiras e transferências financeiras. A aplicação utiliza **Java** com **Spring Boot** e segue uma arquitetura modular, limpa e preparada para escalabilidade.

## 📖 Sobre o Projeto

O **PicPay Simplificado** é uma API que simula uma plataforma de pagamentos simplificada, com as seguintes funcionalidades:
- **Cadastro de usuários**: Permite criar usuários comuns e lojistas, com validação de CPF/CNPJ e e-mail únicos.
- **Gerenciamento de carteiras**: Cada usuário possui uma carteira com saldo para realizar transações.
- **Transferências**: Usuários comuns podem enviar dinheiro para outros usuários ou lojistas, com validações de saldo e autorização externa.
- **Consulta de dados**: Endpoints para listar usuários e verificar detalhes de transações.

O projeto segue as regras de negócio do desafio:
- Usuários comuns podem enviar e receber transferências.
- Lojistas só recebem transferências, não enviam.
- Validação de saldo antes de qualquer transferência.
- Consulta a um serviço autorizador externo (mock) antes de finalizar transferências.
- Transações são atômicas (revertidas em caso de falha).
- Notificações de pagamento (simuladas, considerando possíveis instabilidades de serviços externos).

## 🛠 Tecnologias Utilizadas

- **Java**: Versão 17.
- **Spring Boot**: Framework para construção da API REST.
- **Spring Data JPA**: Para persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Maven**: Gerenciamento de dependências e build.
- **Spring Web**: Para criação de endpoints RESTful.
- **RestTemplate**: Para chamadas ao serviço autorizador externo (mock).
- **JUnit** (opcional): Preparado para testes unitários e de integração.
- **Lombok** (se usado): Para reduzir boilerplate.

## 📋 Pré-requisitos

Para rodar o projeto localmente, você precisa ter instalado:
- **Java JDK** 17 ou superior.
- **Maven** 3.6 ou superior.
- **Git** para clonar o repositório.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar a aplicação:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/pedrohenriquebasilio/Picpaysimplificado.git
   cd Picpaysimplificado
   ```

2. **Instale as dependências**:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API**:
   A aplicação estará disponível em `http://localhost:8080`. Os endpoints principais são:
   - `POST /users`: Cadastra um novo usuário.
     - Exemplo de corpo da requisição:
       ```json
       {
         "fullName": "João Silva",
         "document": "123.456.789-00",
         "email": "joao.silva@example.com",
         "password": "senha123",
         "userType": "COMMON",
         "balance": 1000.00
       }
       ```
   - `POST /transactions`: Realiza uma transferência.
     - Exemplo de corpo da requisição:
       ```json
       {
         "payerId": 1,
         "payeeId": 2,
         "value": 100.00
       }
       ```
   - `GET /users`: Lista todos os usuários.
   - `GET /users/{id}`: Retorna detalhes de um usuário específico.

5. **Acesse o banco H2** (opcional):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:picpay`
   - Usuário: `sa`
   - Senha: (vazio)

## 🧪 Executando Testes

O projeto está preparado para testes unitários e de integração. Caso sejam adicionados, execute-os com:
```bash
mvn test
```

(Nota: Testes podem ser implementados para cobrir serviços, controladores e repositórios.)

## 📜 Estrutura do Projeto

O projeto segue uma organização modular, com separação clara entre camadas:

```
Picpaysimplificado/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/br/picpaysimplificado/
│   │   │       ├── controller/
│   │   │       │   ├── UserController.java       # Endpoints de usuários
│   │   │       │   └── TransactionController.java # Endpoints de transações
│   │   │       ├── domain/
│   │   │       │   ├── User.java                 # Entidade de usuário
│   │   │       │   ├── Wallet.java               # Entidade de carteira
│   │   │       │   └── Transaction.java          # Entidade de transação
│   │   │       ├── service/
│   │   │       │   ├── UserService.java          # Lógica de usuários
│   │   │       │   ├── WalletService.java        # Lógica de carteiras
│   │   │       │   ├── TransactionService.java   # Lógica de transações
│   │   │       │   └── AuthorizationService.java # Integração com serviço externo
│   │   │       ├── repository/
│   │   │       │   ├── UserRepository.java       # Repositório de usuários
│   │   │       │   ├── WalletRepository.java     # Repositório de carteiras
│   │   │       │   └── TransactionRepository.java # Repositório de transações
│   │   │       ├── exception/
│   │   │       │   └── CustomException.java      # Exceções personalizadas
│   │   │       └── PicpaySimplificadoApplication.java # Classe principal
│   │   ├── resources/
│   │   │   └── application.properties           # Configurações do Spring
├── pom.xml                                      # Configuração do Maven
└── README.md                                    # Este arquivo
```

### Detalhes das Camadas

- **Controllers** (`UserController`, `TransactionController`):
  - Expõem endpoints REST para cadastro de usuários e realização de transferências.
  - Tratam requisições e delegam lógica para os serviços.

- **Services** (`UserService`, `WalletService`, `TransactionService`, `AuthorizationService`):
  - Contêm a lógica de negócio.
  - `UserService`: Gerencia cadastro e validação de CPF/CNPJ e e-mail.
  - `WalletService`: Controla saldos das carteiras.
  - `TransactionService`: Valida e processa transferências, garantindo atomicidade.
  - `AuthorizationService`: Integra com o serviço autorizador externo (mock).

- **Domain** (`User`, `Wallet`, `Transaction`):
  - Modelos de dados com anotações JPA para persistência.

- **Repositories** (`UserRepository`, `WalletRepository`, `TransactionRepository`):
  - Interfaces JPA para acesso ao banco de dados.

- **Exceptions** (`CustomException`):
  - Exceções personalizadas para erros como saldo insuficiente, usuário inválido ou falha na autorização.

## 📈 Funcionalidades Principais

- **Cadastro de usuários**:
  - Valida unicidade de CPF/CNPJ e e-mail.
  - Suporta dois tipos de usuário: `COMMON` (comum) e `MERCHANT` (lojista).
- **Transferências**:
  - Verifica se o pagador é um usuário comum (lojistas não podem enviar).
  - Valida saldo suficiente.
  - Consulta o serviço autorizador externo (mock: `https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6`).
  - Garante atomicidade (rollback em caso de falha).
- **Notificações** (simuladas):
  - Preparado para integração com serviços de notificação (mock: `https://run.mocky.io/v3/b19f7b9f-9cbf-4fc6-ad22-dc30601aec04`).
- **Consulta de dados**:
  - Lista usuários e permite buscar detalhes por ID.

## 🔍 Observações

- **Qualidade do código**: O projeto segue padrões profissionais, com separação de camadas e código legível.
- **Robustez**: Validações rigorosas evitam inconsistências, como transferências inválidas.
- **Escalabilidade**: A arquitetura suporta expansão, como adição de novos endpoints ou integração com serviços reais.
- **Segurança**: Dados sensíveis (como senhas) são tratados com cuidado.
- **Mock externo**: A API consome serviços mock para autorização e notificação, conforme especificação do desafio.

## 🤝 Contribuições

Este projeto foi criado para um desafio técnico, mas sugestões são bem-vindas! Para contribuir:
1. Faça um fork do repositório.
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`).
3. Commit suas mudanças (`git commit -m "Adiciona nova funcionalidade"`).
4. Envie para o repositório remoto (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request.

## 📬 Contato

Desenvolvido por **Pedro Henrique Basílio**.  
LinkedIn: [linkedin.com/in/pedrohenriquebasilio](https://linkedin.com/in/pedrohenriquebasilio)  
E-mail: pedrohenriquebasilio@example.com

## 🙌 Agradecimentos

Agradeço à equipe do PicPay pela oportunidade de participar do desafio e aplicar meus conhecimentos em um projeto prático e desafiador!

---
