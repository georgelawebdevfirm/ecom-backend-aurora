package com.maxecommerce.ecom.config;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.Map;

@SuppressWarnings("resource")
public class MySQLResourceLifecycleManager implements QuarkusTestResourceLifecycleManager {

  private final MySQLContainer<?> mySQLContainer =
      new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
          .withStartupTimeout(Duration.ofMinutes(2));

  @Override
  public Map<String, String> start() {
    this.mySQLContainer.start();
    return Map.of(
        "quarkus.datasource.jdbc.url", this.mySQLContainer.getJdbcUrl(),
        "quarkus.datasource.jdbc.driver", this.mySQLContainer.getDriverClassName(),
        "quarkus.datasource.username", this.mySQLContainer.getUsername(),
        "quarkus.datasource.password", this.mySQLContainer.getPassword());
  }

  @Override
  public void stop() {
    mySQLContainer.stop();
  }
}
