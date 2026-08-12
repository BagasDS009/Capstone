package starter.user;

import utils.BaseApi;
import utils.TestDataStore;
import net.thucydides.core.annotations.Step;

public class GetByIdUser extends BaseApi {

    @Step("I set an endpoint for GET user by id")
    public String setAnEndpointForGetUserById(String endpoint) {
        switch (endpoint) {
            case "valid": return baseUrl() + "user/{idUserUpdate}";
            case "invalid": return baseUrl() + "user/0";
            default: return baseUrl() + "user/null";
        }
    }

    @Step("I request {0} for GET detail user")
    public void requestParamGetDetailUser(String param) {
        switch (param) {
            case "dataValid":
                String id = TestDataStore.get(TestDataStore.ID_USER_UPDATE);
                adminRequest().pathParam("idUserUpdate", id).get(baseUrl() + "user/{idUserUpdate}");
                break;
            case "dataInvalid": adminRequest().get(baseUrl() + "user/0"); break;
            default: adminRequest().get(baseUrl() + "user/null"); break;
        }
    }

    @Step("I validate the status code for GET user by id is {0}")
    public void validateTheStatusCodeForGetUserById(int statusCode) { validateStatusCode(statusCode); }

    @Step("validate the data detail after get by id user")
    public void validateTheDataDetailAfterGetByIdUser(String message) {
        switch (message) {
            case "success": validateSuccessResponse(); break;
            case "notFound": validateNotFoundResponse(); break;
            default: validateBadRequestResponse(); break;
        }
    }
}
