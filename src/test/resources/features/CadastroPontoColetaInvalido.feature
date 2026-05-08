# language: pt
@ambiental @pontoColeta @negativo @governanca
Funcionalidade: Validacao de cadastro de ponto de coleta
  Como sistema da Cidade Inteligente ESG
  Quero rejeitar dados invalidos no cadastro de pontos de coleta
  Para assegurar conformidade regulatoria e integridade dos dados ambientais

  Cenário: Tentativa de cadastro de ponto de coleta com tipo de residuo invalido
    Dado que eu tenha os seguintes dados do ponto de coleta:
      | campo        | valor                |
      | nome         |                      |
      | tipoResiduo  | RADIOATIVO           |
      | endereco     | Local desconhecido   |
      | latitude     | 999.0                |
      | longitude    | 999.0                |
    Quando eu enviar a requisicao de cadastro de ponto de coleta para "/pontos-coleta"
    Então o status code da resposta deve ser 400
    E o corpo da resposta deve seguir o contrato "schemas/ErroSchema.json"
    E a resposta deve conter mensagem de erro
