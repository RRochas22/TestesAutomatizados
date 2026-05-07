# language: pt
Funcionalidade: Validação de entrega

Cenário: Tentativa de cadastro com dados inválidos
Dado que eu tenha os seguintes dados inválidos da entrega:
| campo          | valor |
| numeroPedido   |  -1   |
| nomeEntregador |       |
| statusEntrega  | STATUS_INVALIDO |
| dataEntrega    |   2024-99-99    |
Quando eu enviar a requisição para o endpoint "/entregas"
Então o status code da resposta deve ser 400
E a resposta deve conter mensagem de erro