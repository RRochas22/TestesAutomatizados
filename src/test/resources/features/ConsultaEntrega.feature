# language: pt
Funcionalidade: Consulta de entrega

Cenário: Consulta de entrega cadastrada
Dado que exista uma entrega cadastrada com id 1
Quando eu enviar uma requisição GET para o endpoint "/entregas/1"
Então o status code da resposta deve ser 200
E a resposta deve conter os dados da entrega