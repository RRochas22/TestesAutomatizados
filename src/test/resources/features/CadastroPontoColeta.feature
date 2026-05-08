# language: pt
@ambiental @pontoColeta
Funcionalidade: Cadastro de ponto de coleta seletiva
  Como gestor da Cidade Inteligente ESG
  Quero cadastrar pontos de coleta seletiva georreferenciados
  Para garantir a gestao sustentavel de residuos urbanos

  Cenário: Cadastro bem-sucedido de ponto de coleta de plastico
    Dado que eu tenha os seguintes dados do ponto de coleta:
      | campo        | valor                              |
      | nome         | Eco Ponto Vila Verde               |
      | tipoResiduo  | PLASTICO                           |
      | endereco     | Rua das Acacias, 123 - Sao Paulo   |
      | latitude     | -23.55052                          |
      | longitude    | -46.633308                         |
    Quando eu enviar a requisicao de cadastro de ponto de coleta para "/pontos-coleta"
    Então o status code da resposta deve ser 201
    E o corpo da resposta deve seguir o contrato "schemas/PontoColetaSchema.json"
    E o campo "tipoResiduo" da resposta deve ser igual a "PLASTICO"
