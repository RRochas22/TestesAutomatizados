# language: pt
@ambiental @pontoColeta @governanca
Funcionalidade: Consulta de ponto de coleta cadastrado
  Como cidadao
  Quero consultar pontos de coleta seletiva por identificador
  Para usar o servico publico de forma transparente e rastreavel

  Cenário: Consulta de ponto de coleta previamente cadastrado
    Dado que exista um ponto de coleta cadastrado com os dados:
      | campo        | valor                          |
      | nome         | Eco Ponto Centro               |
      | tipoResiduo  | VIDRO                          |
      | endereco     | Praca da Se, s/n - Sao Paulo   |
      | latitude     | -23.55028                      |
      | longitude    | -46.63366                      |
    Quando eu consultar o ponto de coleta recem-criado
    Então o status code da resposta deve ser 200
    E o corpo da resposta deve seguir o contrato "schemas/PontoColetaSchema.json"
    E o campo "nome" da resposta deve ser igual a "Eco Ponto Centro"
