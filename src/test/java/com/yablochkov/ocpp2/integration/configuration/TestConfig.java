package com.yablochkov.ocpp2.integration.configuration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.yablochkov.ocpp2.application.listener.StartupApplicationListener;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;

@TestConfiguration
public class TestConfig {

  @Bean
  public StartupApplicationListener startupApplicationListener() {
//      Disable cold boot on application startup
    var mock = mock(StartupApplicationListener.class);
    doNothing().when(mock).onApplicationEvent(any(ContextRefreshedEvent.class));
    return mock;
  }

}
