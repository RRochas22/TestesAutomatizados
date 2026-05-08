package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import services.TestContext;

public class CommonSteps {

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertNotNull("Nenhuma resposta foi capturada no contexto.", TestContext.response);
        Assert.assertEquals(
                "Status code inesperado. Corpo: " + TestContext.response.asString(),
                statusCode,
                TestContext.response.statusCode());
    }

    @E("o corpo da resposta deve seguir o contrato {string}")
    public void oCorpoDaRespostaDeveSeguirOContrato(String schemaPath) {
        MatcherAssert.assertThat(
                TestContext.response.asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }

    @E("o campo {string} da resposta deve ser igual a {string}")
    public void oCampoDaRespostaDeveSerIgualA(String campo, String valorEsperado) {
        Object atual = TestContext.response.jsonPath().get(campo);
        Assert.assertNotNull("Campo " + campo + " ausente no corpo da resposta.", atual);
        Assert.assertEquals(valorEsperado, String.valueOf(atual));
    }

    @E("a resposta deve conter mensagem de erro")
    public void aRespostaDeveConterMensagemDeErro() {
        String mensagem = TestContext.response.jsonPath().getString("mensagem");
        Assert.assertNotNull("Campo 'mensagem' ausente no corpo de erro.", mensagem);
        Assert.assertFalse("Campo 'mensagem' nao pode estar vazio.", mensagem.isBlank());
    }
}
