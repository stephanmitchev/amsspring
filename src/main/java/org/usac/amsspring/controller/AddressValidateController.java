package org.usac.amsspring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.usac.amsspring.model.Address;
import org.usac.amsspring.model.AddressInquiryResult;
import org.usac.amsspring.provider.AmsNativeProvider;

/**
 * Servlet to handle address validation requests.
 */
@RestController
public class AddressValidateController
{
    private Logger logger = LoggerFactory.getLogger(AddressValidateController.class);

    @Autowired
    private AmsNativeProvider amsNativeProvider;

    @RequestMapping("/validate")
    public Address validateAddress(@RequestParam(value="addr1") String addr1,
                                   @RequestParam(value="addr2") String addr2,
                                   @RequestParam(value="city") String city,
                                   @RequestParam(value="state") String state,
                                   @RequestParam(value="zip") String zip)
    {
        Object responseObj;

        Address inputAddress = new Address(addr1, addr2, city, state, zip);
        AddressInquiryResult result = amsNativeProvider.addressInquiry(inputAddress);

        return result.getUspsAddress().getValidatedAddress();
    }
}