package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import services.CidadaoService;

import java.util.List;
import java.util.Map;

public class CidadaoSteps {

    private final CidadaoService service = new CidadaoService();

    @Dado("que eu tenha os seguintes dados do cidadao:")
    public void queEuTenhaOsSeguintesDadosDoCidadao(List<Map<String, String>> linhas) {
        for (Map<String, String> linha : linhas) {
            service.setCampo(linha.get("campo"), linha.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao de cadastro de cidadao para {string}")
    public void euEnviarARequisicaoDeCadastroDeCidadaoPara(String endpoint) {
        service.cadastrar(endpoint);
    }
}
