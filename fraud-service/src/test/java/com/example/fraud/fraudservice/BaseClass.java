package com.example.fraud.fraudservice;

import com.example.fraud.fraudservice.controller.FraudController;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.util.Collection;

@SpringBootTest(classes= FraudServiceApplication.class)
public class BaseClass {

    @Autowired
    private FraudController fraudController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private WireMock wireMock;

    @BeforeEach
    public void setup() {
        //RestAssuredMockMvc.standaloneSetup(fraudController);

        final Collection<Filter> filterCollection = this.webApplicationContext.getBeansOfType(Filter.class).values();
        final Filter[] filters = filterCollection.toArray(new Filter[filterCollection.size()]);
        RestAssuredMockMvc.mockMvc(MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                                        .addFilters(filters).build());

        //this.wireMock  = new WireMock(8090);
        //this.wireMock.resetRequests();
    }
}
