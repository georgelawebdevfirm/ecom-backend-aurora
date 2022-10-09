package com.maxecommerce.ecom.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxecommerce.ecom.action.ActionEventConfig;
import com.maxecommerce.ecom.domain.product.Product;
import com.maxecommerce.ecom.dto.lambda.Input;
import com.maxecommerce.ecom.dto.lambda.Output;
import com.maxecommerce.ecom.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@Named("product")
public class ProductLambda implements RequestStreamHandler {

  @Inject ProductService productService;
  @Inject ObjectMapper mapper;

  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
    try{
      final Input input = mapper.readValue(inputStream, Input.class);
      final ActionEventConfig actionEventConfig =
              ActionEventConfig.getActionEventConfig(input.getActionEvent()).orElseThrow();
      if (actionEventConfig == ActionEventConfig.PRODUCT_CREATE) {
        final Product result = productService.create(mapper.readValue(input.getBody(), Product.class));
        final Output output = Output.getInstance(mapper.writeValueAsString(result));
        mapper.writeValue(outputStream, output);
      }
    } catch (Exception e) {
      log.error("Cannot perform action", e);
    }

  }
}
