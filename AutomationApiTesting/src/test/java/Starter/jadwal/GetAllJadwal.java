package starter.jadwal;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetAllJadwal extends BaseApi {

    private String endpoint() { return baseUrl() + "jadwal/"; }

    @Step("I set an endpoint for GET all schedule")
    public String getEndpointSchedule() { return endpoint(); }

    @Step("I request get detail list schedule")
    public void requestGetListSchedule() { adminRequest().when().get(endpoint()); }

    @Step("verify status code get all schedule is {0}")
    public void verifyStatusCodeSchedule(int code) { validateStatusCode(code); }

    @Step("validate the data detail after get schedule")
    public void setValidateDataDetailAfterGetSchedule() { validateSuccessResponse(); }
}
