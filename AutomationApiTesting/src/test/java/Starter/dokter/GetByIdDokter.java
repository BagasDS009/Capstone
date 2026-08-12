package starter.dokter;

import utils.BaseApi;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;

public class GetByIdDokter extends BaseApi {

    @Step("I set an endpoint for GET doctor by id")
    public String setAnEndpointForGetDoctorById(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "dokter/{idDokterUpdate}";
            case "invalid": return baseUrl() + "dokter/0";
            default: return baseUrl() + "dokter/null";
        }
    }

    @Step("I request {0} for GET detail doctor by id")
    public void requestParamGetDetailDoctor(String param) {
        switch (param) {
            case "dataValid":
                String id = TestDataStore.get(TestDataStore.ID_DOKTER_UPDATE);
                adminRequest().pathParam("idDokterUpdate", id).get(baseUrl() + "dokter/{idDokterUpdate}");
                break;
            case "dataInvalid":
                adminRequest().get(baseUrl() + "dokter/0");
                break;
            default:
                adminRequest().get(baseUrl() + "dokter/null");
                break;
        }
    }

    @Step("I validate the status code for GET doctor by id is {0}")
    public void validateTheStatusCodeForGetDoctorById(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after get by id doctor")
    public void validateTheDataDetailAfterGetByIdDoctor(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
