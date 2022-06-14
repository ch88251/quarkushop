package com.cfhayes.quarkushop.web;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.QuarkusTestResource;

import com.cfhayes.quarkushop.utils.TestContainerResource;

import static io.restassured.RestAssured.get;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.greaterThan;


@QuarkusTest
@QuarkusTestResource(TestContainerResource.class)
public class CartResourceTest {

    @Test
    public void testFindAll() {
        get("/carts")
            .then()
                .statusCode(OK.getStatusCode())
                .body("size()", greaterThan(0));
    }
}
