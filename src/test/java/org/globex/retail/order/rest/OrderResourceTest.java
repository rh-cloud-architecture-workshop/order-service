package org.globex.retail.order.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
public class OrderResourceTest {

    @Test
    void testStoreOrder() {
        String response = RestAssured.given()
                .when()
                .header("Content-type", "application/json")
                .body(buildOrder()).post("/order")
                .then()
                .statusCode(200)
                .extract().asString();
        assertThat(response, notNullValue());
        JsonObject json = new JsonObject(response);
        assertThat(json.getString("order"), notNullValue());
        assertThat(Integer.valueOf(json.getString("order")), Matchers.greaterThan(0));
    }

    private String buildOrder() {
        JsonObject order = new JsonObject().put("customer", "testcustomer")
                .put("shippingAddress", new JsonObject().put("name", "John Doe")
                        .put("phone", "111-222-333-444")
                        .put("address1", "1 Some Street")
                        .put("address2", "")
                        .put("city", "New York")
                        .put("zip", "12345")
                        .put("state", "NY")
                        .put("country", "USA"))
                .put("lineItems", new JsonArray().add(new JsonObject().put("product", "product1")
                        .put("quantity", 1).put("price", 8.99)).add(new JsonObject().put("product", "product2")
                        .put("quantity", 2).put("price", 18.99)));
        return order.encodePrettily();
    }

}
