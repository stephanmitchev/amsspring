package org.usac.amsspring.response;

import org.usac.amsspring.model.CityStateResult;
import org.usac.amsspring.view.FacilityCodeView;
import org.usac.amsspring.view.ZipClassCodeView;

public class DetailCityStateResponse extends BaseCityStateResponse {

    protected ZipClassCodeView zipClass;
    protected FacilityCodeView facility;
    protected char mailingNameInd;
    protected String preferredCity;
    protected String countyNum;
    protected String countyName;

    public DetailCityStateResponse(CityStateResult result, boolean initCaps)
    {
        super(result, initCaps);
        if(result != null && result.getCityRecord() != null)
        {
            this.zipClass = new ZipClassCodeView(result.getCityRecord().getZipClassCode());
            this.facility = new FacilityCodeView(result.getCityRecord().getFacilityCd());
            this.mailingNameInd = result.getCityRecord().getMailingNameInd();
            this.preferredCity = result.getCityRecord().getPreferredCity();
            this.countyNum = result.getCityRecord().getCountyNum();
            this.countyName = result.getCityRecord().getCountyName();
        }
    }

    public ZipClassCodeView getZipClass() {
        return zipClass;
    }

    public FacilityCodeView getFacility() {
        return facility;
    }

    public String getMailingNameInd() {
        return Character.toString(mailingNameInd);
    }

    public String getPreferredCity() {
        return preferredCity;
    }

    public String getCountyNum() {
        return countyNum;
    }

    public String getCountyName() {
        return countyName;
    }
}
