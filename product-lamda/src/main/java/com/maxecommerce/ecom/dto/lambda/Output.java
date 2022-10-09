package com.maxecommerce.ecom.dto.lambda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {

  private Boolean isBase64Encoded;
  private Integer statusCode;
  private Map<String, String> headers;
  private String body;

  public static Output getInstance(final String body) {
    final Output output = new Output();
    final Map<String, String> headers = new HashMap<>();
    headers.put("Access-Control-Allow-Origin", "*");
    headers.put("Content-Type", "application/json");
    output.setIsBase64Encoded(false).setStatusCode(200).setHeaders(headers).setBody(body);
    return output;
  }
}
