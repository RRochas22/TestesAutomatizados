package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import services.ConsumoEnergeticoService;

import java.util.List;
import java.util.Map;

public class ConsumoEnergeticoSteps {

    private final ConsumoEnergeticoService service = new ConsumoEnergeticoService();

    @Dado("que eu tenha os seguintes dados do consumo energetico:")
    public void queEuTenhaOsSeguintesDadosDoConsumoEnergetico(List<Map<String, String>> linhas) {
        for (Map<String, String> linha : linhas) {
            service.setCampo(linha.get("campo"), linha.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao de registro de consumo energetico para {string}")
    public void euEnviarARequisicaoDeRegistroDeConsumoEnergeticoPara(String endpoint) {
        service.registrar(endpoint);
    }
}
