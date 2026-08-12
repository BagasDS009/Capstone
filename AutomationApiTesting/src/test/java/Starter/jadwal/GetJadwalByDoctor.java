package starter.jadwal;

import utils.BaseApi;
import net.thucydides.core.annotations.Step;

public class GetJadwalByDoctor extends BaseApi {

    private String endpoint() { return baseUrl() + "jadwal/jadwalbydokter/"; }

    @Step("I set endpoint for GET schedule by doctor")
    public String getEndpointScheduleByDoctor() { return endpoint(); }

    @Step("I request get data schedule by doctor")
    public void requestGetDataScheduleByDoctor() { doctorRequest().when().get(endpoint()); }

    @Step("verify status code get schedule by doctor is {0}")
    public void verifyStatusCodeByScheduleDoctor(int code) { validateStatusCode(code); }

    @Step("validate the data detail after get schedule by doctor")
    public void setValidateDataDetailAfterGetDataScheduleDoctor() { validateSuccessResponse(); }
}
