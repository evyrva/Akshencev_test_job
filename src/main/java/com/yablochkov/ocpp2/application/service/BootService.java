package com.yablochkov.ocpp2.application.service;

import com.yablochkov.ocpp2.adapter.csms.CsmsClient;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class BootService {

  private final CsmsClient csmsClient;

  public void bootUp() {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    BootNotificationResponse bootNotificationResponse = csmsClient.sendBootNotification(new BootNotificationRequest());

    while (bootNotificationResponse.getStatus() == BootNotificationResponse.Status.PENDING) {
      try {
        TimeUnit.SECONDS.sleep(bootNotificationResponse.getInterval());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bootNotificationResponse = csmsClient.sendBootNotification(new BootNotificationRequest());
    }

    if (bootNotificationResponse.getStatus() == BootNotificationResponse.Status.ACCEPTED) {
      executorService.scheduleAtFixedRate(() -> csmsClient.sendHeartbeat(new HeartbeatRequest()), 0, bootNotificationResponse.getInterval(), TimeUnit.SECONDS);
    } else {
      executorService.shutdown();
      System.exit(1);
    }
  }
}
