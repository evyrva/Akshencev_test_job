package com.yablochkov.ocpp2.adapter.csms;

import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatResponse;

public interface CsmsClient {

  BootNotificationResponse sendBootNotification(BootNotificationRequest bootNotificationRequest);

  HeartbeatResponse sendHeartbeat(HeartbeatRequest heartbeatRequest);

}
