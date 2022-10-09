package com.maxecommerce.ecom.lambda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxecommerce.ecom.config.MySQLResourceLifecycleManager;
import com.maxecommerce.ecom.domain.product.Product;
import com.maxecommerce.ecom.dto.lambda.Input;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
@QuarkusTestResource(MySQLResourceLifecycleManager.class)
class ProductHandlerTest {

  @Inject ObjectMapper mapper;

  @Test
  void testSimpleLambdaSuccess() throws Exception {

    // GIVEN
    final Input in = new Input();
    final Product product = new Product().setName("New product");
    in.setBody(mapper.writeValueAsString(product));
    in.setActionEvent("create-product");

    given()
        .contentType("application/json")
        .accept("application/json")
        .body(in)
        .when()
        .post()
        .then()
        .statusCode(200)
        .body(containsString("New product"));
  }
}
