package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import model.ConsumoEnergeticoModel;

import static io.restassured.RestAssured.given;

public class ConsumoEnergeticoService {

    private final ConsumoEnergeticoModel consumo = new ConsumoEnergeticoModel();
    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    private final String baseUrl = System.getProperty("api.baseUrl", "http://localhost:8080");

    public void setCampo(String campo, String valor) {
        switch (campo) {
            case "idResidencia" -> consumo.setIdResidencia(valor);
            case "mesReferencia" -> consumo.setMesReferencia(valor);
            case "consumoKwh" -> consumo.setConsumoKwh(valor.isEmpty() ? null : Double.parseDouble(valor));
            case "fonteEnergia" -> consumo.setFonteEnergia(valor);
            default -> throw new IllegalArgumentException("Campo desconhecido: " + campo);
        }
    }

    public void registrar(String endpoint) {
        String body = gson.toJson(consumo);
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
