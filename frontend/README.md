## Comunicação entre frontend e backend

O frontend utiliza Axios para realizar as requisições para a API. O backend possui CORS configurado para permitir a comunicação com o frontend.

# API

| Método | Endpoint | Função |
|---|---|---|
| GET | `/Destino` | Lista os destinos |
| GET | `/Destino/{id}` | Busca por ID |
| POST | `/Destino` | Cadastra um destino |
| PUT | `/Destino/{id}` | Atualiza um destino |
| DELETE | `/Destino/{id}` | Exclui um destino |

## Códigos HTTP

| Código | Significado |
|---|---|
| 200 | Sucesso |
| 201 | Recurso criado |
| 400 | Dados inválidos |
| 404 | Recurso não encontrado |
| 204 | Recurso excluído |

## Validações

A API valida os dados antes do cadastro e da atualização. Os campos obrigatórios são nome, cidade, estado, descrição e preço médio. O preço médio não pode ser menor que zero.

## Banco de dados

O projeto utiliza o H2 como banco de dados relacional. A tabela utilizada é `destino`.

O script de criação está localizado em:

`projetoindividual/src/main/resources/schema.sql`

## Testes

Os endpoints foram testados utilizando o Bruno. Também foram realizados testes de integração entre o frontend React e o backend.

## Controle de versão

O projeto utiliza Git e GitHub para o versionamento do código.



  

