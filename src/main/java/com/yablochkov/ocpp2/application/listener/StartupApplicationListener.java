package com.yablochkov.ocpp2.application.listener;

import com.yablochkov.ocpp2.application.service.BootService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

  private final BootService bootService;

  @SneakyThrows
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    bootService.bootUp();
  }
}
