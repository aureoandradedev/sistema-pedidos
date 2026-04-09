# Sistema de Pedidos

## 📌 Descrição

API REST para gerenciamento de pedidos, produtos e pagamentos, simulando fluxo real de negócio com validações, transações e regras.

---

## 🚀 Tecnologias

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Lombok
* Swagger (OpenAPI)

---

## 📦 Funcionalidades

* Cadastro de produtos
* Criação de pedidos com múltiplos itens
* Processamento de pagamento
* Simulação de pagamento aprovado ou recusado
* Atualização automática do status do pedido

---

## 🧠 Regras de Negócio

* Um pedido só pode ser pago uma vez
* Não é possível pagar um pedido já confirmado
* Não é possível pagar um pedido cancelado
* O status do pedido é atualizado automaticamente com base no resultado do pagamento
* As operações de pagamento são transacionais (rollback em caso de erro)

---

## 🔄 Fluxo de negócio

Pedido criado → Status PENDENTE

Pagamento processado →

* APROVADO → Pedido CONFIRMADO
* RECUSADO → Pedido CANCELADO

---

## 🏗️ Arquitetura

O projeto segue arquitetura em camadas:

* Controller → entrada da API
* Service → regras de negócio
* Repository → acesso ao banco
* DTO → transferência de dados

---

## ⚙️ Como rodar o projeto

1. Clonar o repositório:

```
git clone [https://github.com/seu-usuario/sistema-pedidos-api.git](https://github.com/aureoandradedev/sistema-pedidos.git)
```

2. Acessar a pasta:

```
cd sistema-pedidos-api
```

3. Rodar a aplicação:

```
./mvnw spring-boot:run
```

4. A API estará disponível em:

```
http://localhost:8085
```

---

## 📖 Documentação da API (Swagger)

Acesse:

```
http://localhost:8085/swagger-ui/index.html
```

---

## 📌 Endpoints principais

* POST /produtos
* GET /produtos
* POST /pedidos
* POST /pagamentos

---

## 📬 Exemplo de requisição

### Criar Pedido

POST /pedidos

```
{
  "pedidosItens": [
    {
      "produtoId": 1,
      "quantidade": 2
    }
  ]
}
```

---

### Processar Pagamento

POST /pagamentos

```
{
  "pedidoId": 1
}
```

---

## 🔒 Segurança

Este projeto não possui autenticação/autorização implementada, pois o foco está nas regras de negócio.

Como evolução futura:

* Spring Security + JWT
* Controle de acesso por usuário

---

## 🚀 Melhorias futuras

* Autenticação com JWT
* Logs estruturados
* Testes automatizados
* Integração com gateway de pagamento real
