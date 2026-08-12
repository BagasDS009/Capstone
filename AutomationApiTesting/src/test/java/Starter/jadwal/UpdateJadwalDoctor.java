package starter.jadwal;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateJadwalDoctor extends BaseApi {

    private String endpointValid() { return baseUrl() + "jadwal/editbydokter/{idJadwalNew}"; }
    private String endpointInvalid() { return baseUrl() + "jadwal/editbydokter/0"; }
    private String endpointNull() { return baseUrl() + "jadwal/editbydokter/null"; }

    @Step("I set an endpoint for update schedule doctor")
    public String setAnEndpointForUpdateScheduleDoctor(String endpoint) {
        switch (endpoint) {
            case "valid": return endpointValid();
            case "invalid": return endpointInvalid();
            default: return endpointNull();
        }
    }

    @Step("I request {0} for update detail schedule doctor")
    public void requestUpdateFieldDetailScheduleDoctor(String field) {
        switch (field) {
            case "validAll":        put("2022-07-11", DataGenerator.note(), "Diabetes"); break;
            case "nullEndpoint":    putTo("2022-06-27", DataGenerator.note(), "Diabetes", endpointNull()); break;
            case "invalidEndpoint": putTo("2022-06-27", DataGenerator.note(), "Diabetes", endpointInvalid()); break;
            case "emptyNote":       put("2022-07-11", "", "Diabetes"); break;
            case "emptyDiagnosa":   put("2022-07-11", DataGenerator.note(), ""); break;
            case "invalidControl":  put("99", DataGenerator.note(), "Diabetes"); break;
            default:                put("date", DataGenerator.note(), "Diabetes"); break;
        }
    }

    @Step("I validate the status code for update schedule doctor is {0}")
    public void validateTheStatusCodeForUpdateDataScheduleDoctor(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after update schedule doctor")
    public void validateTheDataDetailAfterUpdateScheduleDoctor(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            case "badRequest": validateBadRequestResponse(); break;
            case "notSupport": restAssuredThat(r -> r.body("error", equalTo("Unsupported Media Type"))); break;
            default: validateErrorResponse(); break;
        }
    }

    private void put(String controll, String catatan, String diagnosa) {
        JSONObject body = buildBody("controll", controll, "catatan", catatan, "diagnosa", diagnosa);
        String id = TestDataStore.get(TestDataStore.ID_JADWAL_NEW);
        doctorRequest().pathParam("idJadwalNew", id).body(body.toJSONString()).put(endpointValid());
    }

    private void putTo(String controll, String catatan, String diagnosa, String url) {
        JSONObject body = buildBody("controll", controll, "catatan", catatan, "diagnosa", diagnosa);
        doctorRequest().body(body.toJSONString()).put(url);
    }
}
