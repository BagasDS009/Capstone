package starter.jadwal;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateJadwalAdmin extends BaseApi {

    private String endpointValid() { return baseUrl() + "jadwal/{idJadwalNew}"; }
    private String endpointInvalid() { return baseUrl() + "jadwal/0"; }
    private String endpointNull() { return baseUrl() + "jadwal/null"; }

    @Step("I set an endpoint for update schedule admin")
    public String setAnEndpointForUpdateScheduleAdmin(String endpoint) {
        switch (endpoint) {
            case "valid": return endpointValid();
            case "invalid": return endpointInvalid();
            default: return endpointNull();
        }
    }

    @Step("I request {0} for update detail schedule admin")
    public void requestUpdateFieldDetailScheduleAdmin(String field) {
        switch (field) {
            case "validAll":        put(9, 13, DataGenerator.queueNumber(), "Rawat Inap", "2022-07-11"); break;
            case "nullEndpoint":    putTo(null, null, DataGenerator.queueNumber(), "Rawat Inap", "2022-06-27", endpointNull()); break;
            case "invalidEndpoint": putTo(1, 1, DataGenerator.queueNumber(), "Rawat Inap", "2022-06-27", endpointInvalid()); break;
            case "invalidId":       put(DataGenerator.id(), DataGenerator.id(), DataGenerator.queueNumber(), "Rawat Inap", "2022-06-27"); break;
            case "invalidAntrian":  put(1, 10, 0, "Rawat Inap", "2022-06-27"); break;
            case "invalidPerawatan": put(1, 10, DataGenerator.queueNumber(), "255232432", "2022-06-27"); break;
            case "emptyPerawatan":  put(1, 1, DataGenerator.queueNumber(), "", "2022-06-27"); break;
            case "emptyDate":       put(1, 1, DataGenerator.queueNumber(), "Rawat Inap", ""); break;
            case "invalidDate":     put(1, 1, DataGenerator.queueNumber(), "Rawat Inap", "2022"); break;
            case "stringDate":      put(1, 1, DataGenerator.queueNumber(), "Rawat Inap", "Date"); break;
            default:                putNull(); break;
        }
    }

    @Step("I validate the status code for update schedule admin is {0}")
    public void validateTheStatusCodeForUpdateDataScheduleAdmin(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after update schedule admin")
    public void validateTheDataDetailAfterUpdateScheduleAdmin(String message) {
        switch (message) {
            case "success":
                TestDataStore.set(TestDataStore.ID_JADWAL_UPDATE, getResponseValue("data.id"));
                validateSuccessResponse();
                break;
            case "notFound": validateNotFoundResponse(); break;
            case "badRequest": validateBadRequestResponse(); break;
            case "notSupport": restAssuredThat(r -> r.body("error", equalTo("Unsupported Media Type"))); break;
            default: validateErrorResponse(); break;
        }
    }

    private void put(int dokterId, int pasienId, int noUrut, String jp, String tanggal) {
        JSONObject body = buildBody("dokter_id", dokterId, "pasien_id", pasienId, "nourut", noUrut, "jp", jp, "tanggal", tanggal);
        String id = TestDataStore.get(TestDataStore.ID_JADWAL_NEW);
        adminRequest().pathParam("idJadwalNew", id).body(body.toJSONString()).put(endpointValid());
    }

    private void putTo(Integer dokterId, Integer pasienId, int noUrut, String jp, String tanggal, String url) {
        JSONObject body = buildBody("dokter_id", dokterId, "pasien_id", pasienId, "nourut", noUrut, "jp", jp, "tanggal", tanggal);
        adminRequest().body(body.toJSONString()).put(url);
    }

    private void putNull() {
        JSONObject body = buildBody("dokter_id", null, "pasien_id", null, "nourut", null, "jp", null, "tanggal", null);
        String id = TestDataStore.get(TestDataStore.ID_JADWAL_NEW);
        adminRequest().pathParam("idJadwalNew", id).body(body.toJSONString()).put(endpointValid());
    }
}
