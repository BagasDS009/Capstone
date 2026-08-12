package starter.dokter;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetAllDokter extends BaseApi {

    private String endpoint() {
        return baseUrl() + "dokter/";
    }

    @Step("I set an endpoint for GET all doctor")
    public String getEndpointDoctor() {
        return endpoint();
    }

    @Step("I request get detail list doctor")
    public void requestGetListDoctor() {
        adminRequest().when().get(endpoint());
    }

    @Step("verify status code get all doctor is {0}")
    public void verifyStatusCodeDoctor(int code) {
        validateStatusCode(code);
    }

    @Step("validate the data detail after get doctor")
    public void setValidateDataDetailAfterGetDoctor() {
        validateSuccessResponse();
    }
}
