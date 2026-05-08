package services;

import io.restassured.response.Response;

public class TestContext {
    public static Response response;
    public static String requestBody;
    public static Integer recursoIdCriado;

    public static void reset() {
        response = null;
        requestBody = null;
        recursoIdCriado = null;
    }
}
