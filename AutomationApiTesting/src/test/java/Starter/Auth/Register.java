package starter.auth;

import utils.BaseApi;
import utils.DataGenerator;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class Register extends BaseApi {

    private String endpoint() {
        return baseUrl() + "api/auth/register/";
    }

    @Step("I set an endpoint for register")
    public String setEndpointRegister() {
        return endpoint();
    }

    @Step("I request {0} for register new account")
    @SuppressWarnings("unchecked")
    public void requestRegisterNewAccount(String field) {
        switch (field) {
            case "emptyAll":
                postRegister("", "");
                break;
            case "nullAll":
                postRegister(null, null);
                break;
            case "invalidUser": {
                String usedUsername = TestDataStore.has(TestDataStore.USED_USERNAME)
                        ? TestDataStore.get(TestDataStore.USED_USERNAME) : "admin";
                JSONObject body = new JSONObject();
                body.put("username", new String[]{usedUsername});
                body.put("password", "sasa123");
                publicRequest().body(body.toJSONString()).post(endpoint());
                break;
            }
            default:
                postRegister(DataGenerator.username(), DataGenerator.password());
                break;
        }
    }

    @Step("I validate the status code for register new account is {0}")
    public void validateTheStatusCodeForRegisterNewAccount(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after register new account")
    public void validateTheDataDetailAfterRegisterNewAccount(String message) {
        if (message.equals("success")) {
            String userId = getResponseValue("data.id");
            String newUsername = getResponseValue("data.username");
            TestDataStore.set(TestDataStore.ID_USER_NEW, userId);
            TestDataStore.set(TestDataStore.USED_USERNAME, newUsername);
            validateSuccessResponse();
        } else if (message.equals("badRequest")) {
            validateBadRequestResponse();
        }
    }

    private void postRegister(String username, String password) {
        JSONObject body = buildBody("username", username, "password", password);
        publicRequest().body(body.toJSONString()).post(endpoint());
    }
}
