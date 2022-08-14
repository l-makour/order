package com.checkconsulting.order;

import com.checkconsulting.order.model.Orders;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = OrderApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTestIT {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void itShouldReturnAllOrders(){
        Orders[] result = testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/orders", Orders[].class);
        Assertions.assertEquals(result.length, 2);
    }



}
