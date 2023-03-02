package com.yablochkov.ocpp2.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.yablochkov.ocpp2.adapter.csms.CsmsClient;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse.Status;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatResponse;
import com.yablochkov.ocpp2.application.service.BootService;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ColdBootTest extends AbstractIntegrationTest {
  @MockBean
  CsmsClient csmsClient;
  @Autowired
  BootService bootService;

  private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

  @Test
  public void testColdBootAccepted() {
    when(csmsClient.sendBootNotification(any())).thenReturn(new BootNotificationResponse(
        LocalDateTime.now(), 1, Status.ACCEPTED));
    when(csmsClient.sendHeartbeat(any())).thenReturn(new HeartbeatResponse(LocalDateTime.now()));

    bootService.bootUp();

    var inOrder = inOrder(csmsClient);
    inOrder.verify(csmsClient, times(1)).sendBootNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendHeartbeat(any());
  }

  @Test
  public void testColdBootPending() {
    when(csmsClient.sendBootNotification(any()))
        .thenReturn(new BootNotificationResponse(
            LocalDateTime.now(), 1, Status.PENDING))
        .thenReturn(new BootNotificationResponse(
            LocalDateTime.now(), 1, Status.ACCEPTED));
    when(csmsClient.sendHeartbeat(any())).thenReturn(new HeartbeatResponse(LocalDateTime.now()));

    bootService.bootUp();

    var inOrder = inOrder(csmsClient);
    inOrder.verify(csmsClient, times(2)).sendBootNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendHeartbeat(any());
  }


}
