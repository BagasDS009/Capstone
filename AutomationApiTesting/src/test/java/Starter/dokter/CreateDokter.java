package starter.dokter;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class CreateDokter extends BaseApi {

    private String endpoint() {
        return baseUrl() + "dokter/";
    }

    @Step("I set an endpoint for create doctor")
    public String setEndpointDoctor() {
        return endpoint();
    }

    @Step("I request {0} for create data doctor")
    public void requestCreateDataDoctor(String field) {
        switch (field) {
            case "emptyName":      postDoctor(9, "", "Dokter Umum", DataGenerator.npaIdi()); break;
            case "invalidName":    postDoctor(9, "23442", "Dokter Umum", DataGenerator.npaIdi()); break;
            case "emptySpesialis": postDoctor(9, DataGenerator.doctorName(), "", DataGenerator.npaIdi()); break;
            case "invalidSpesialis": postDoctor(9, DataGenerator.doctorName(), "252532", DataGenerator.npaIdi()); break;
            case "emptySrp":       postDoctor(9, DataGenerator.doctorName(), "Dokter Umum", ""); break;
            case "invalidSrp":     postDoctor(9, DataGenerator.doctorName(), "Dokter Umum", "NPA IDI"); break;
            case "emptyAll":       postDoctor(9, "", "", ""); break;
            case "invalidAll":     postDoctor(0, "14141", "141414", "NPA Idi"); break;
            case "nullAll":        postDoctorNull(); break;
            case "invalidId":      postDoctor(0, DataGenerator.doctorName(), "Dokter Umum", DataGenerator.npaIdi()); break;
            default:               postDoctor(32, DataGenerator.doctorName(), "Dokter Umum", DataGenerator.npaIdi()); break;
        }
    }

    @Step("I validate the status code for create doctor is {0}")
    public void validateTheStatusCodeForCreateDoctor(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after create doctor")
    public void validateTheDataDetailAfterCreateDoctor(String message) {
        if (message.equals("success")) {
            TestDataStore.set(TestDataStore.ID_DOKTER_NEW, getResponseValue("data.id"));
            validateSuccessResponse();
        } else if (message.equals("badRequest")) {
            validateBadRequestResponse();
        } else {
            validateErrorResponse();
        }
    }

    private void postDoctor(int userId, String name, String spesialis, String srp) {
        JSONObject body = buildBody("user_id", userId, "namadokter", name, "spesialis", spesialis, "srp", srp);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }

    private void postDoctorNull() {
        JSONObject body = buildBody("user_id", null, "namadokter", null, "spesialis", null, "srp", null);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }
}
