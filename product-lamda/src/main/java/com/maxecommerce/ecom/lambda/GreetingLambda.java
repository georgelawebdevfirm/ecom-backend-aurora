package com.maxecommerce.ecom.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Named;

@Named("product")
public class GreetingLambda implements RequestHandler<Person, String> {

  @Override
  public String handleRequest(Person input, Context context) {
    return "Hello " + input.getName();
  }
}
