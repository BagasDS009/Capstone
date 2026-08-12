package starter.pasien;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class DeletePasien extends BaseApi {

    @Step("I set an endpoint for delete patient")
    public String setAnEndpointForDeletePatient(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "pasien/19";
            case "invalid": return baseUrl() + "pasien/0";
            default: return baseUrl() + "pasien/null";
        }
    }

    @Step("I request {0} for delete detail patient")
    public void requestParamDeleteDetailPatient(String param) {
        String url;
        switch (param) {
            case "dataValid": url = baseUrl() + "pasien/19"; break;
            case "dataInvalid": url = baseUrl() + "pasien/0"; break;
            default: url = baseUrl() + "pasien/null"; break;
        }
        adminRequest().when().delete(url);
    }

    @Step("I validate the status code for delete patient is {0}")
    public void validateTheStatusCodeForDeletePatient(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after delete patient")
    public void validateTheDataDetailAfterDeletePatient(String message) {
        switch (message) {
            case "success": break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
