package com.maxecommerce.ecom.dto.lambda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity {

  String cognitoIdentityPoolId;
  String accountId;
  String cognitoIdentityId;
  String caller;
  String apiKey;
  String sourceIp;
  String cognitoAuthenticationType;
  String cognitoAuthenticationProvider;
  String userArn;
  String userAgent;
  String user;

}
