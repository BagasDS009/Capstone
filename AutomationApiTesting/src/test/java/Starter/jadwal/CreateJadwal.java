package starter.jadwal;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class CreateJadwal extends BaseApi {

    private String endpoint() { return baseUrl() + "jadwal/"; }

    @Step("I set an endpoint for create schedule")
    public String setEndpointSchedule() { return endpoint(); }

    @Step("I request {0} for create data schedule")
    public void requestCreateDataSchedule(String field) {
        switch (field) {
            case "invalidId":       post(DataGenerator.id(), DataGenerator.id(), DataGenerator.queueNumber(), "Rawat Jalan", "2022-06-27"); break;
            case "emptyDate":       post(DataGenerator.id(), DataGenerator.id(), DataGenerator.queueNumber(), "Rawat Jalan", null); break;
            case "emptyAll":        post(1, 10, DataGenerator.queueNumber(), "", ""); break;
            case "invalidAntrian":  post(9, 10, 0, "Rawat Jalan", "2022-06-27"); break;
            case "invalidPerawatan": post(1, 10, DataGenerator.queueNumber(), "412411", "2022-06-27"); break;
            case "nullAll":         postNull(); break;
            case "invalidDate":     post(DataGenerator.id(), DataGenerator.id(), DataGenerator.queueNumber(), "Rawat Jalan", "1"); break;
            case "invalidAll":      post(DataGenerator.id(), DataGenerator.id(), 0, "353343", "1"); break;
            case "stringDate":      postStringDate(); break;
            default:                post(9, 13, DataGenerator.queueNumber(), "Perawatan Biasa", "2022-07-10"); break;
        }
    }

    @Step("I validate the status code for create schedule is {0}")
    public void validateTheStatusCodeForCreateSchedule(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after create schedule")
    public void validateTheDataDetailAfterCreateSchedule(String message) {
        if (message.equals("success")) {
            TestDataStore.set(TestDataStore.ID_JADWAL_NEW, getResponseValue("data.id"));
            validateSuccessResponse();
        } else if (message.equals("error")) {
            validateErrorResponse();
        } else {
            validateBadRequestResponse();
        }
    }

    private void post(int dokterId, int pasienId, int noUrut, String jp, String tanggal) {
        JSONObject body = buildBody("dokter_id", dokterId, "pasien_id", pasienId, "nourut", noUrut, "jp", jp, "tanggal", tanggal);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }

    private void postNull() {
        JSONObject body = buildBody("dokter_id", null, "pasien_id", null, "nourut", null, "jp", null, "tanggal", null);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }

    private void postStringDate() {
        JSONObject body = buildBody("dokter_id", null, "pasien_id", null, "nourut", DataGenerator.queueNumber(), "jp", "Rawat Jalan", "tanggal", "x");
        adminRequest().body(body.toJSONString()).post(endpoint());
    }
}
