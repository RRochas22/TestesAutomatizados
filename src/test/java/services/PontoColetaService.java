package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import model.PontoColetaModel;

import static io.restassured.RestAssured.given;

public class PontoColetaService {

    private final PontoColetaModel ponto = new PontoColetaModel();
    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    private final String baseUrl = System.getProperty("api.baseUrl", "http://localhost:8080");

    public void setCampo(String campo, String valor) {
        switch (campo) {
            case "nome" -> ponto.setNome(valor);
            case "tipoResiduo" -> ponto.setTipoResiduo(valor);
            case "endereco" -> ponto.setEndereco(valor);
            case "latitude" -> ponto.setLatitude(valor.isEmpty() ? null : Double.parseDouble(valor));
            case "longitude" -> ponto.setLongitude(valor.isEmpty() ? null : Double.parseDouble(valor));
            default -> throw new IllegalArgumentException("Campo desconhecido: " + campo);
        }
    }

    public void cadastrar(String endpoint) {
        String body = gson.toJson(ponto);
        TestContext.requestBody = body;
        TestContext.response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(baseUrl + endpoint)
                .then()
                .extract()
                .response();

        if (TestContext.response.statusCode() == 201) {
            TestContext.recursoIdCriado = TestContext.response.jsonPath().getInt("id");
        }
    }

    public void consultarPorId(String endpoint) {
        TestContext.response = given()
                .accept(ContentType.JSON)
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }
}
