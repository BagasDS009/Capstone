package starter.pasien;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class UpdatePasien extends BaseApi {

    private String endpointValid() { return baseUrl() + "pasien/{idPasienNew}"; }
    private String endpointInvalid() { return baseUrl() + "pasien/0"; }
    private String endpointNull() { return baseUrl() + "pasien/null"; }

    @Step("I set an endpoint for update patient")
    public String setAnEndpointForUpdatePatient(String endpoint) {
        switch (endpoint) {
            case "valid": return endpointValid();
            case "invalid": return endpointInvalid();
            default: return endpointNull();
        }
    }

    @Step("I request {0} for update detail patient")
    public void requestUpdateFieldDetailPatient(String field) {
        switch (field) {
            case "validAll":        put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address()); break;
            case "nullEndpoint":    putTo(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address(), endpointNull()); break;
            case "invalidEndpoint": putTo(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address(), endpointInvalid()); break;
            case "emptyName":       put("", DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidName":     put("2555252", DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyNik":        put(DataGenerator.patientName(), "", DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidNik":      put(DataGenerator.patientName(), "Nomer Induk", DataGenerator.age(), "Perempuan", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyGender":     put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "", DataGenerator.phone(), DataGenerator.address()); break;
            case "invalidGender":   put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "5234224", DataGenerator.phone(), DataGenerator.address()); break;
            case "emptyPhone":      put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", "", DataGenerator.address()); break;
            case "invalidPhone":    put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", "phone number", DataGenerator.address()); break;
            case "emptyAddress":    put(DataGenerator.patientName(), DataGenerator.nik(), DataGenerator.age(), "Perempuan", DataGenerator.phone(), ""); break;
            case "emptyAll":        put("", "", DataGenerator.age(), "", "", ""); break;
            case "invalidAll":      put("35352", "NIK", DataGenerator.age(), "5242432", "Phone Number", DataGenerator.address()); break;
            default:                putNull(); break;
        }
    }

    @Step("I validate the status code for update patient is {0}")
    public void validateTheStatusCodeForUpdateDataPatient(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data details after update patient")
    public void validateTheDataDetails(String message) {
        switch (message) {
            case "success":
                TestDataStore.set(TestDataStore.ID_PASIEN_UPDATE, getResponseValue("data.id"));
                validateSuccessResponse();
                break;
            case "notFound": validateNotFoundResponse(); break;
            case "badRequest": validateBadRequestResponse(); break;
            default: validateErrorResponse(); break;
        }
    }

    private void put(String name, String nik, String age, String gender, String phone, String address) {
        JSONObject body = buildBody("namapasien", name, "nik", nik, "umur", age, "jeniskelamin", gender, "telp", phone, "alamat", address);
        String id = TestDataStore.get(TestDataStore.ID_PASIEN_NEW);
        adminRequest().pathParam("idPasienNew", id).body(body.toJSONString()).put(endpointValid());
    }

    private void putTo(String name, String nik, String age, String gender, String phone, String address, String url) {
        JSONObject body = buildBody("namapasien", name, "nik", nik, "umur", age, "jeniskelamin", gender, "telp", phone, "alamat", address);
        adminRequest().body(body.toJSONString()).put(url);
    }

    private void putNull() {
        JSONObject body = buildBody("namapasien", null, "nik", null, "umur", null, "jeniskelamin", null, "telp", null, "alamat", null);
        String id = TestDataStore.get(TestDataStore.ID_PASIEN_NEW);
        adminRequest().pathParam("idPasienNew", id).body(body.toJSONString()).put(endpointValid());
    }
}
