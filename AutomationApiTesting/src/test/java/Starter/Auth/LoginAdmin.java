package starter.auth;

import utils.BaseApi;
import utils.ConfigManager;
import utils.DataGenerator;
import utils.TokenManager;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class LoginAdmin extends BaseApi {

    private String endpoint() {
        return baseUrl() + "api/auth/login/";
    }

    @Step("I set an endpoint for login account admin")
    public String setEndpointLoginAccountAdmin() {
        return endpoint();
    }

    @Step("I request {0} for login account admin")
    public void requestLoginAccountAdmin(String field) {
        String username = ConfigManager.getAdminUsername();
        String password = ConfigManager.getAdminPassword();
        String role = ConfigManager.getAdminRole();

        switch (field) {
            case "emptyUser":  postLogin("", password, role); break;
            case "emptyPass":  postLogin(username, "", role); break;
            case "emptyRole":  postLogin(username, password, ""); break;
            case "emptyAll":   postLogin("", "", ""); break;
            case "nullAll":    postLogin(null, null, role); break;
            case "invalidUser": postLogin(DataGenerator.username(), password, role); break;
            case "invalidPass": postLogin(username, DataGenerator.password(), role); break;
            case "invalidRole": postLogin(username, password, "ROLES"); break;
            case "invalidAll":  postLogin(DataGenerator.username(), DataGenerator.password(), "ROLES"); break;
            default: postLogin(username, password, role); break;
        }
    }

    @Step("I validate the status code for login admin is {0}")
    public void validateTheStatusCodeForLoginAdmin(int statusCode) {
        validateStatusCode(statusCode);
    }

    @Step("validate the data detail after login account admin")
    public void validateTheDataDetailAfterLoginAccountAdmin(String message) {
        if (message.equals("success")) {
            String token = getResponseValue("token");
            TokenManager.setAdminToken(token);
        } else if (message.equals("badRequest")) {
            validateBadRequestResponse();
        }
    }

    private void postLogin(String username, String password, String role) {
        JSONObject body = buildBody("username", username, "password", password, "role", role);
        publicRequest().body(body.toJSONString()).post(endpoint());
    }
}
