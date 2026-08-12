package starter.pasien;

import utils.BaseApi;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;

public class GetByIdPasien extends BaseApi {

    @Step("I set an endpoint for GET patient by id")
    public String setAnEndpointForGetPatientById(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "pasien/{idPasienUpdate}";
            case "invalid": return baseUrl() + "pasien/0";
            default: return baseUrl() + "pasien/null";
        }
    }

    @Step("I request {0} for GET detail patient")
    public void requestParamGetDetailPatient(String param) {
        switch (param) {
            case "dataValid":
                String id = TestDataStore.get(TestDataStore.ID_PASIEN_UPDATE);
                adminRequest().pathParam("idPasienUpdate", id).get(baseUrl() + "pasien/{idPasienUpdate}");
                break;
            case "dataInvalid":
                adminRequest().get(baseUrl() + "pasien/0");
                break;
            default:
                adminRequest().get(baseUrl() + "pasien/null");
                break;
        }
    }

    @Step("I validate the status code for GET patient by id is {0}")
    public void validateTheStatusCodeForGetPatientById(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after get by id patient")
    public void validateTheDataDetails(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
