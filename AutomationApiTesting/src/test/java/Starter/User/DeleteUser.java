package starter.user;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class DeleteUser extends BaseApi {

    @Step("I set an endpoint for delete user")
    public String setAnEndpointForDeleteUser(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "user/30";
            case "invalid": return baseUrl() + "user/0";
            default: return baseUrl() + "user/null";
        }
    }

    @Step("I request {0} for delete detail user")
    public void requestParamDeleteDetailUser(String param) {
        String url;
        switch (param) {
            case "dataValid": url = baseUrl() + "user/30"; break;
            case "dataInvalid": url = baseUrl() + "user/0"; break;
            default: url = baseUrl() + "user/null"; break;
        }
        adminRequest().when().delete(url);
    }

    @Step("I validate the status code for delete user is {0}")
    public void validateTheStatusCodeForDeleteUser(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after delete user")
    public void validateTheDataDetailAfterDeleteUser(String message) {
        switch (message) {
            case "success": break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
