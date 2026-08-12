package starter.pasien;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class CreatePasien extends BaseApi {

    private String endpoint() { return baseUrl() + "pasien/"; }

    @Step("I set an endpoint for create patient")
    public String setEndpointPatient() { return endpoint(); }

    @Step("I request {0} for create data patient")
    public void requestCreateDataPatient(String field) {
        switch (field) {
            case "emptyName":    post("", DataGenerator.nik(), DataGenerator.age(), "Laki laki", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidName":  post("2352252", DataGenerator.nik(), DataGenerator.age(), "Laki laki", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyNik":     post(DataGenerator.patientName(), "", DataGenerator.age(), "Laki laki", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidNik":   post(DataGenerator.patientName(), "NomerInduk", DataGenerator.age(), "Laki laki", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyGender":  post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidGender": post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "6186146", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyPhone":   post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Laki laki", "", DataGenerator.address()); break;
            case "invalidPhone": post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Laki laki", "numberPhone", DataGenerator.address()); break;
            case "emptyAddress": post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Laki laki", DataGenerator.phone(), ""); break;
            case "emptyAll":     post("", "", DataGenerator.age(), "", "", ""); break;
            case "invalidAll":   post("313141", "Number Induk", DataGenerator.age(), "3232321", "ddvds", DataGenerator.address()); break;
            case "nullAll":      postNull(); break;
            default:             post(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Laki laki", DataGenerator.phone(), DataGenerator.address()); break;
        }
    }

    @Step("I validate the status code for create patient is {0}")
    public void validateTheStatusCodeForCreatePatient(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data details after create patient")
    public void validateTheDataDetails(String message) {
        if (message.equals("success")) {
            TestDataStore.set(TestDataStore.ID_PASIEN_NEW, getResponseValue("data.id"));
            validateSuccessResponse();
        } else if (message.equals("badRequest")) {
            validateBadRequestResponse();
        } else {
            validateErrorResponse();
        }
    }

    private void post(String name, String nik, String age, String gender, String phone, String address) {
        JSONObject body = buildBody("namapasien", name, "nik", nik, "umur", age, "jeniskelamin", gender, "telp", phone, "alamat", address);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }

    private void postNull() {
        JSONObject body = buildBody("namapasien", null, "nik", null, "umur", null, "jeniskelamin", null, "telp", null, "alamat", null);
        adminRequest().body(body.toJSONString()).post(endpoint());
    }
}
