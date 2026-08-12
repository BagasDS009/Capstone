package starter.pasien;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetAllPasien extends BaseApi {

    private String endpoint() { return baseUrl() + "pasien/"; }

    @Step("I set an endpoint for GET all patient")
    public String getEndpointPatient() { return endpoint(); }

    @Step("I request get detail list patient")
    public void requestGetListPatient() {
        adminRequest().when().get(endpoint());
    }

    @Step("verify status code get all patient is {0}")
    public void verifyStatusCodePatient(int code) { validateStatusCode(code); }

    @Step("validate the data detail after get patient")
    public void setValidateDataDetailAfterGetPatient() { validateSuccessResponse(); }
}
