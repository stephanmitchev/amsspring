package org.usac.amsspring.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.usac.amsspring.model.AddressInquiryResult;
import org.usac.amsspring.provider.AmsNativeProvider;
import org.usac.amsspring.response.BaseAddressInquiryResponse;
import org.usac.amsspring.response.BatchResponse;
import org.usac.amsspring.response.DetailAddressInquiryResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zip9InquiryController extends BaseApiController
{
    private Logger logger = LoggerFactory.getLogger(Zip9InquiryController.class);
    @Autowired
    private AmsNativeProvider amsNativeProvider;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        //this.amsNativeProvider = Application.getAmsNativeProvider();
        logger.debug("Initialized Zip9InquiryController.");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object responseObj;

        boolean batch = isBatch(request);
        boolean detail = isDetail(request);
        boolean initCaps = isInitCaps(request);

        if (batch) {
            String json = IOUtils.toString(request.getInputStream(), "UTF-8");
            List<String> zip9List = getZip9ListFromJson(json);
            List<AddressInquiryResult> results = new ArrayList<>();
            if (zip9List != null && zip9List.size() > 0) {
                results = amsNativeProvider.zip9Inquiry(zip9List);
            }
            List<BaseAddressInquiryResponse> baseResponses = new ArrayList<>();
            List<DetailAddressInquiryResponse> detailResponses = new ArrayList<>();
            for (AddressInquiryResult result : results) {
                if (!detail) {
                    baseResponses.add(new BaseAddressInquiryResponse(result, initCaps));
                }
                else {
                    detailResponses.add(new DetailAddressInquiryResponse(result, initCaps));
                }
            }
            if (!detail) {
                responseObj = new BatchResponse<>(baseResponses);
            }
            else {
                responseObj = new BatchResponse<>(detailResponses);
            }
            //ApiFilter.setApiResponse(responseObj, request);
        }
        else {
            doGet(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object responseObj;

        boolean detail = isDetail(request);
        String zip9 = getZip9FromParams(request);
        boolean initCaps = isInitCaps(request);

        AddressInquiryResult result = amsNativeProvider.zip9Inquiry(zip9);

        if (!detail) {
            responseObj = new BaseAddressInquiryResponse(result, initCaps);
        }
        else {
            responseObj = new DetailAddressInquiryResponse(result, initCaps);
        }

        //ApiFilter.setApiResponse(responseObj, request);
    }
}
