package starter.user;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetAllUser extends BaseApi {

    private String endpoint() { return baseUrl() + "user/"; }

    @Step("I set an endpoint for GET all user")
    public String getEndpointUser() { return endpoint(); }

    @Step("I request get detail list user")
    public void requestGetListUser() { adminRequest().when().get(endpoint()); }

    @Step("verify status code get all user is {0}")
    public void verifyStatusCodeUser(int code) { validateStatusCode(code); }

    @Step("validate the data detail after get user")
    public void setValidateDataDetailAfterGetUser() { validateSuccessResponse(); }
}
