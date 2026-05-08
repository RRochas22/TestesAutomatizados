package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import model.CidadaoModel;

import static io.restassured.RestAssured.given;

public class CidadaoService {

    private final CidadaoModel cidadao = new CidadaoModel();
    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    private final String baseUrl = System.getProperty("api.baseUrl", "http://localhost:8080");

    public void setCampo(String campo, String valor) {
        switch (campo) {
            case "nome" -> cidadao.setNome(valor);
            case "cpf" -> cidadao.setCpf(valor);
            case "necessidadeAcessibilidade" -> cidadao.setNecessidadeAcessibilidade(Boolean.parseBoolean(valor));
            case "tipoAcessibilidade" -> cidadao.setTipoAcessibilidade(valor);
            default -> throw new IllegalArgumentException("Campo desconhecido: " + campo);
        }
    }

    public void cadastrar(String endpoint) {
        String body = gson.toJson(cidadao);
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
    }
}
