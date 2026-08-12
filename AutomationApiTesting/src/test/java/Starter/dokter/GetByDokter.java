package starter.dokter;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetByDokter extends BaseApi {

    private String endpoint() {
        return baseUrl() + "dokter/getbydokter/";
    }

    @Step("I set an endpoint for GET by token doctor")
    public String getEndpointByDoctor() {
        return endpoint();
    }

    @Step("I request get data by doctor token")
    public void requestGetDataByDoctor() {
        doctorRequest().when().get(endpoint());
    }

    @Step("verify status code get by doctor is {0}")
    public void verifyStatusCodeByDoctor(int code) {
        validateStatusCode(code);
    }

    @Step("validate the data detail after get data doctor")
    public void setValidateDataDetailAfterGetDataDoctor() {
        validateSuccessResponse();
    }
}
