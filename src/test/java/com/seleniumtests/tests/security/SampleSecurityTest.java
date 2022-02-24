package com.seleniumtests.tests.security;

import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import com.seleniumtests.blogexamples.driversetup.BaseSecurity;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SampleSecurityTest extends BaseSecurity {

    private static final String BASE_URL = "http://qa.portal-ui-mock.sdwan.novitas.internal.colt.net/";

    @Test()
    public void spiderHomePage() throws ClientApiException, InterruptedException {
        getDriver().get(BASE_URL);
        spiderTarget(BASE_URL);
    }

    @Test()
    public void passiveScanHomePage() throws ClientApiException {
        getDriver().get(BASE_URL);
        // some more logic using page object to move to different pages goes here
        waitForPassiveScanToComplete();
        checkRiskCount(BASE_URL);
    }

    @Test()
    public void activeScanHomePage() throws ClientApiException, InterruptedException {
        getDriver().get(BASE_URL);
        activeScan(BASE_URL);
        checkRiskCount(BASE_URL);
    }

}