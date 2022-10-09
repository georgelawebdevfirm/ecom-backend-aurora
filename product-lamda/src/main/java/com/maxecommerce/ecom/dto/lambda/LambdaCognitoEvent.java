package com.maxecommerce.ecom.dto.lambda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LambdaCognitoEvent {
  private Map<String, String> userAttributes;
}
