package com.maxecommerce.ecom.dto.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Input implements Serializable {

  @Serial private static final long serialVersionUID = 8563428125726641250L;

  private String resource;
  private String path;
  private String httpMethod;
  private Map<String, String> headers;
  private Map<String, String> queryStringParameters;
  private Map<String, String> pathParameters;
  private Map<String, String> stageVariables;
  private transient RequestContext requestContext;
  private String body;
  private String isBase64Encoded;
  private transient Context context;
  private String cognitoUser;
  private String actionEvent;
  private Boolean callFromLambda;

  // CloudWatch event
  private String source;

  // Cognito Trigger
  // Request data
  private String triggerSource;
  private String version;
  private String region;
  private String userPoolId;
  private String userName;
  private transient LambdaCognitoEvent request;
}
