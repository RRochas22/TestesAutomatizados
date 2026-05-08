package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import services.PontoColetaService;
import services.TestContext;

import java.util.List;
import java.util.Map;

public class PontoColetaSteps {

    private final PontoColetaService service = new PontoColetaService();

    @Dado("que eu tenha os seguintes dados do ponto de coleta:")
    public void queEuTenhaOsSeguintesDadosDoPontoDeColeta(List<Map<String, String>> linhas) {
        for (Map<String, String> linha : linhas) {
            service.setCampo(linha.get("campo"), linha.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao de cadastro de ponto de coleta para {string}")
    public void euEnviarARequisicaoDeCadastroDePontoDeColetaPara(String endpoint) {
        service.cadastrar(endpoint);
    }

    @Dado("que exista um ponto de coleta cadastrado com os dados:")
    public void queExistaUmPontoDeColetaCadastradoComOsDados(List<Map<String, String>> linhas) {
        for (Map<String, String> linha : linhas) {
            service.setCampo(linha.get("campo"), linha.get("valor"));
        }
        service.cadastrar("/pontos-coleta");
    }

    @Quando("eu consultar o ponto de coleta recem-criado")
    public void euConsultarOPontoDeColetaRecemCriado() {
        if (TestContext.recursoIdCriado == null) {
            throw new IllegalStateException("Nenhum ponto de coleta foi criado previamente.");
        }
        service.consultarPorId("/pontos-coleta/" + TestContext.recursoIdCriado);
    }
}
