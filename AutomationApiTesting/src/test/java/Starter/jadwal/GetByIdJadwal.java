package starter.jadwal;

import utils.BaseApi;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;

public class GetByIdJadwal extends BaseApi {

    @Step("I set an endpoint for GET schedule by id")
    public String setAnEndpointForGetScheduleById(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "jadwal/{idJadwalUpdate}";
            case "invalid": return baseUrl() + "jadwal/0";
            default: return baseUrl() + "jadwal/null";
        }
    }

    @Step("I request {0} for GET detail schedule")
    public void requestParamGetDetailSchedule(String param) {
        switch (param) {
            case "dataValid":
                String id = TestDataStore.get(TestDataStore.ID_JADWAL_UPDATE);
                adminRequest().pathParam("idJadwalUpdate", id).get(baseUrl() + "jadwal/{idJadwalUpdate}");
                break;
            case "dataInvalid": adminRequest().get(baseUrl() + "jadwal/0"); break;
            default: adminRequest().get(baseUrl() + "jadwal/null"); break;
        }
    }

    @Step("I validate the status code for GET schedule by id is {0}")
    public void validateTheStatusCodeForGetScheduleById(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after get by id schedule")
    public void validateTheDataDetailAfterGetByIdSchedule(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
