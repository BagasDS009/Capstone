package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Base class for all API interactions.
 * Provides common request building and response validation methods.
 */
public class BaseApi {

    protected static String baseUrl() {
        return ConfigManager.getBaseUrl();
    }

    protected RequestSpecification adminRequest() {
        return SerenityRest.given()
                .header("Authorization", "Bearer " + TokenManager.getAdminToken())
                .header("Content-Type", "application/json");
    }

    protected RequestSpecification doctorRequest() {
        return SerenityRest.given()
                .header("Authorization", "Bearer " + TokenManager.getDoctorToken())
                .header("Content-Type", "application/json");
    }

    protected RequestSpecification publicRequest() {
        return SerenityRest.given()
                .header("Content-Type", "application/json");
    }

    protected void validateStatusCode(int expectedCode) {
        SerenityRest.then().statusCode(equalTo(expectedCode));
    }

    protected void validateSuccessResponse() {
        restAssuredThat(response -> response.body("responseCode", equalTo("SUCCESS")));
        restAssuredThat(response -> response.body("message", equalTo("Success!")));
    }

    protected void validateErrorResponse() {
        restAssuredThat(response -> response.body("responseCode", equalTo("UNKNOWN_ERROR")));
        restAssuredThat(response -> response.body("message", equalTo("Happened error!")));
    }

    protected void validateBadRequestResponse() {
        restAssuredThat(response -> response.body("error", equalTo("Bad Request")));
    }

    protected void validateNotFoundResponse() {
        restAssuredThat(response -> response.body("responseCode", equalTo("DATA_NOT_FOUND")));
        restAssuredThat(response -> response.body("message", equalTo("Data not found!")));
    }

    protected String getResponseValue(String jsonPath) {
        Response response = SerenityRest.lastResponse();
        return response.jsonPath().getString(jsonPath);
    }

    @SuppressWarnings("unchecked")
    protected JSONObject buildBody(Object... keyValues) {
        JSONObject body = new JSONObject();
        for (int i = 0; i < keyValues.length; i += 2) {
            body.put(keyValues[i], keyValues[i + 1]);
        }
        return body;
    }
}
