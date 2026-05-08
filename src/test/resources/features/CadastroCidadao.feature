# language: pt
@social @cidadao @inclusao
Funcionalidade: Cadastro de cidadao com dados de acessibilidade
  Como sistema da Cidade Inteligente ESG
  Quero registrar cidadaos com suas necessidades de acessibilidade
  Para oferecer servicos publicos inclusivos e adequados a diversidade

  Cenário: Cadastro bem-sucedido de cidadao com necessidade de acessibilidade visual
    Dado que eu tenha os seguintes dados do cidadao:
      | campo                       | valor          |
      | nome                        | Maria Oliveira |
      | cpf                         | 12345678901    |
      | necessidadeAcessibilidade   | true           |
      | tipoAcessibilidade          | VISUAL         |
    Quando eu enviar a requisicao de cadastro de cidadao para "/cidadaos"
    Então o status code da resposta deve ser 201
    E o corpo da resposta deve seguir o contrato "schemas/CidadaoSchema.json"
    E o campo "tipoAcessibilidade" da resposta deve ser igual a "VISUAL"
