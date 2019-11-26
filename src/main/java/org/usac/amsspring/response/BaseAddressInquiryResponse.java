package org.usac.amsspring.response;


import org.usac.amsspring.model.AddressInquiryResult;
import org.usac.amsspring.model.Footnote;
import org.usac.amsspring.model.StatusCode;
import org.usac.amsspring.model.USPSAddress;
import org.usac.amsspring.view.AddressView;
import org.usac.amsspring.view.FootnoteView;
import org.usac.amsspring.view.StatusCodeView;

import java.util.ArrayList;

public class BaseAddressInquiryResponse
{
    protected boolean validated;
    protected AddressView address;
    protected StatusCodeView status;
    protected ArrayList<FootnoteView> footnotes = new ArrayList<>();

    public BaseAddressInquiryResponse(AddressInquiryResult result, boolean initCaps)
    {
        if (result != null) {
            StatusCode statusCode = result.getStatusCode();
            USPSAddress uspsAddress = result.getUspsAddress();
            if (statusCode != null) {
                if (statusCode.equals(StatusCode.EXACT_MATCH) || statusCode.equals(StatusCode.DEFAULT_MATCH)) {
                    this.validated = true;
                }
                this.status = new StatusCodeView(result.getStatusCode());
            }
            else {
                this.status = new StatusCodeView(StatusCode.UNKNOWN_ERROR);
            }
            if (uspsAddress != null) {
                this.address = new AddressView(uspsAddress.getValidatedAddress(), initCaps);
            }
            if (result.getFootnotes() != null && !result.getFootnotes().isEmpty()) {
                for (Footnote footnote : result.getFootnotes()) {
                    this.footnotes.add(new FootnoteView(footnote));
                }
            }
        }
    }

    public boolean isValidated() {
        return validated;
    }

    public AddressView getAddress() {
        return address;
    }

    public StatusCodeView getStatus() {
        return status;
    }

    public ArrayList<FootnoteView> getFootnotes() {
        return footnotes;
    }
}
