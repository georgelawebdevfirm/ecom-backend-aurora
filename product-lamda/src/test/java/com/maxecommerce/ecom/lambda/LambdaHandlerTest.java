package com.maxecommerce.ecom.lambda;

import com.maxecommerce.ecom.dto.lambda.Input;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class LambdaHandlerTest {

  @Test
  void testSimpleLambdaSuccess() throws Exception {
    Input in = new Input();
    in.setBody("{}");
    in.setActionEvent("create-product");
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(in)
        .when()
        .post()
        .then()
        .statusCode(200)
        .body(containsString("Hello Stu"));
  }
}
