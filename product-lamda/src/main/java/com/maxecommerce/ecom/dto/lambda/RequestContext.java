package com.maxecommerce.ecom.dto.lambda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestContext {

  String accountId;

  String resourceId;

  String stage;

  String requestId;

  Identity identity;

  String resourcePath;

  String httpMethod;

  String apiId;
}
