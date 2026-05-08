# language: pt
@ambiental @consumoEnergia
Funcionalidade: Registro de consumo energetico mensal
  Como sistema da Cidade Inteligente ESG
  Quero registrar o consumo energetico das residencias por fonte
  Para promover eficiencia energetica e priorizar fontes renovaveis

  Cenário: Registro bem-sucedido de consumo proveniente de fonte solar
    Dado que eu tenha os seguintes dados do consumo energetico:
      | campo          | valor       |
      | idResidencia   | RES-0001    |
      | mesReferencia  | 2026-04     |
      | consumoKwh     | 215.75      |
      | fonteEnergia   | SOLAR       |
    Quando eu enviar a requisicao de registro de consumo energetico para "/consumo-energia"
    Então o status code da resposta deve ser 201
    E o corpo da resposta deve seguir o contrato "schemas/ConsumoEnergeticoSchema.json"
    E o campo "fonteEnergia" da resposta deve ser igual a "SOLAR"
