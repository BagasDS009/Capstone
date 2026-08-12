package starter.dokter;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class DeleteDokter extends BaseApi {

    @Step("I set an endpoint for delete doctor")
    public String setAnEndpointForDeleteDoctor(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "dokter/20";
            case "invalid": return baseUrl() + "dokter/0";
            default: return baseUrl() + "dokter/null";
        }
    }

    @Step("I request {0} for delete detail doctor")
    public void requestParamDeleteDetailDoctor(String param) {
        String url;
        switch (param) {
            case "dataValid": url = baseUrl() + "dokter/20"; break;
            case "dataInvalid": url = baseUrl() + "dokter/0"; break;
            default: url = baseUrl() + "dokter/null"; break;
        }
        adminRequest().when().delete(url);
    }

    @Step("I validate the status code for delete doctor is {0}")
    public void validateTheStatusCodeForDeleteDoctor(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after delete doctor")
    public void validateTheDataDetailAfterDeleteDoctor(String message) {
        switch (message) {
            case "success": break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
