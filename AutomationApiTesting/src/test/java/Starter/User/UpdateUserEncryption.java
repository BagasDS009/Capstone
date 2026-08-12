package starter.user;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class UpdateUserEncryption extends BaseApi {

    private String endpointValid() { return baseUrl() + "api/auth/updateuser/{idUserNew}"; }
    private String endpointInvalid() { return baseUrl() + "api/auth/updateuser/0"; }
    private String endpointNull() { return baseUrl() + "api/auth/updateuser/null"; }

    @Step("I set an endpoint for update user encryption")
    public String setAnEndpointForUpdateUserEncryption(String endpoint) {
        switch (endpoint) {
            case "valid": return endpointValid();
            case "invalid": return endpointInvalid();
            default: return endpointNull();
        }
    }

    @Step("I request {0} for update detail user encryption")
    public void requestUpdateFieldDetailUserEncryption(String field) {
        switch (field) {
            case "validAll":        put(DataGenerator.username(), DataGenerator.password()); break;
            case "nullEndpoint":    putTo(DataGenerator.username(), DataGenerator.password(), endpointNull()); break;
            case "invalidEndpoint": putTo(DataGenerator.username(), DataGenerator.password(), endpointInvalid()); break;
            case "emptyUsername":   put("", DataGenerator.password()); break;
            case "emptyPassword":   put(DataGenerator.username(), ""); break;
            case "emptyAll":        put("", ""); break;
            default:                putNull(); break;
        }
    }

    @Step("I validate the status code for update user encryption is {0}")
    public void validateTheStatusCodeForUpdateDataUserEncryption(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after update user encryption")
    public void validateTheDataDetailAfterUpdateUserEncryption(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            case "badRequest": validateBadRequestResponse(); break;
            default: validateErrorResponse(); break;
        }
    }

    private void put(String username, String password) {
        JSONObject body = buildBody("new_username", username, "new_password", password);
        String id = TestDataStore.get(TestDataStore.ID_USER_NEW);
        adminRequest().pathParam("idUserNew", id).body(body.toJSONString()).put(endpointValid());
    }

    private void putTo(String username, String password, String url) {
        JSONObject body = buildBody("new_username", username, "new_password", password);
        adminRequest().body(body.toJSONString()).put(url);
    }

    private void putNull() {
        JSONObject body = buildBody("new_username", null, "new_password", null);
        String id = TestDataStore.get(TestDataStore.ID_USER_NEW);
        adminRequest().pathParam("idUserNew", id).body(body.toJSONString()).put(endpointValid());
    }
}
