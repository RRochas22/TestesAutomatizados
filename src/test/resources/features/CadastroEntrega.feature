# language: pt
Funcionalidade: Cadastro de entrega

Cenário: Cadastro bem-sucedido de entrega
Dado que eu tenha os seguintes dados da entrega:
| campo          | valor        |
| numeroPedido   | 1            |
| nomeEntregador | Luiz Silva   |
| statusEntrega  | EM_SEPARACAO |
| dataEntrega    | 2025-12-22   |

Quando eu enviar a requisição para o endpoint "/entregas"
Então o status code da resposta deve ser 201