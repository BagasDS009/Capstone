package starter.dokter;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class UpdateDokter extends BaseApi {

    private String endpointValid() { return baseUrl() + "dokter/{idDokterNew}"; }
    private String endpointInvalid() { return baseUrl() + "dokter/0"; }
    private String endpointNull() { return baseUrl() + "dokter/null"; }

    @Step("I set an endpoint for update doctor")
    public String setAnEndpointForUpdateDoctor(String endpoint) {
        switch (endpoint) {
            case "valid": return endpointValid();
            case "invalid": return endpointInvalid();
            default: return endpointNull();
        }
    }

    @Step("I request {0} for update detail doctor")
    public void requestUpdateFieldDetailDoctor(String field) {
        switch (field) {
            case "validAll":        putDoctor(17, DataGenerator.doctorName(), "Dokter Gigi", DataGenerator.npaIdi()); break;
            case "nullEndpoint":    putDoctorTo(9, DataGenerator.doctorName(), "Dokter Gigi", DataGenerator.npaIdi(), endpointNull()); break;
            case "invalidEndpoint": putDoctorTo(9, DataGenerator.doctorName(), "Dokter Gigi", DataGenerator.npaIdi(), endpointInvalid()); break;
            case "emptyName":       putDoctor(9, "", "Dokter Gigi", DataGenerator.npaIdi()); break;
            case "invalidName":     putDoctor(9, "4342242", "Dokter Gigi", DataGenerator.npaIdi()); break;
            case "emptySpesialis":  putDoctor(9, DataGenerator.doctorName(), "", DataGenerator.npaIdi()); break;
            case "invalidSpesialis": putDoctor(9, DataGenerator.doctorName(), "2414241", DataGenerator.npaIdi()); break;
            case "emptySrp":        putDoctor(9, DataGenerator.doctorName(), "Dokter Gigi", ""); break;
            case "InvalidSrp":      putDoctor(9, DataGenerator.doctorName(), "Dokter Gigi", "NPA IDI"); break;
            case "emptyAll":        putDoctor(9, "", "", ""); break;
            case "invalidAll":      putDoctor(0, "32434412", "14211", "NPA IDI"); break;
            case "invalidId":       putDoctor(0, DataGenerator.doctorName(), "Dokter Gigi", DataGenerator.npaIdi()); break;
            default:                putDoctorNull(); break;
        }
    }

    @Step("I validate the status code for update doctor is {0}")
    public void validateTheStatusCodeForUpdateDataDoctor(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after update doctor")
    public void validateTheDataDetailAfterUpdateDoctor(String message) {
        switch (message) {
            case "success":
                TestDataStore.set(TestDataStore.ID_DOKTER_UPDATE, getResponseValue("data.id"));
                validateSuccessResponse();
                break;
            case "notFound": validateNotFoundResponse(); break;
            case "badRequest": validateBadRequestResponse(); break;
            default: validateErrorResponse(); break;
        }
    }

    private void putDoctor(int userId, String name, String spesialis, String srp) {
        JSONObject body = buildBody("user_id", userId, "namadokter", name, "spesialis", spesialis, "srp", srp);
        String id = TestDataStore.get(TestDataStore.ID_DOKTER_NEW);
        adminRequest().pathParam("idDokterNew", id).body(body.toJSONString()).put(endpointValid());
    }

    private void putDoctorTo(int userId, String name, String spesialis, String srp, String url) {
        JSONObject body = buildBody("user_id", userId, "namadokter", name, "spesialis", spesialis, "srp", srp);
        adminRequest().body(body.toJSONString()).put(url);
    }

    private void putDoctorNull() {
        JSONObject body = buildBody("user_id", null, "namadokter", null, "spesialis", null, "srp", null);
        String id = TestDataStore.get(TestDataStore.ID_DOKTER_NEW);
        adminRequest().pathParam("idDokterNew", id).body(body.toJSONString()).put(endpointValid());
    }
}
