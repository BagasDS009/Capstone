package starter.jadwal;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class DeleteJadwal extends BaseApi {

    @Step("I set an endpoint for delete schedule")
    public String setAnEndpointForDeleteSchedule(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "jadwal/18";
            case "invalid": return baseUrl() + "jadwal/0";
            default: return baseUrl() + "jadwal/null";
        }
    }

    @Step("I request {0} for delete detail schedule")
    public void requestParamDeleteDetailSchedule(String param) {
        String url;
        switch (param) {
            case "dataValid": url = baseUrl() + "jadwal/18"; break;
            case "dataInvalid": url = baseUrl() + "jadwal/0"; break;
            default: url = baseUrl() + "jadwal/null"; break;
        }
        adminRequest().when().delete(url);
    }

    @Step("I validate the status code for delete schedule is {0}")
    public void validateTheStatusCodeForDeleteSchedule(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after delete schedule")
    public void validateTheDataDetailAfterDeleteSchedule(String message) {
        switch (message) {
            case "success": break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
