package com.yablochkov.ocpp2.application.service;

import com.yablochkov.ocpp2.adapter.csms.CsmsClient;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootService {

  private final CsmsClient csmsClient;

  public void bootUp() {
    //TODO implement cold boot logic
    csmsClient.sendBootNotification(new BootNotificationRequest());
    csmsClient.sendHeartbeat(new HeartbeatRequest());
  }

}
