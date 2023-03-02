package com.yablochkov.ocpp2.application.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("instance")
@Data
public class InstanceProperties {

  private String vendorId;
  private String modelId;
  private String firmwareVersion;
  private String serialNumber;

}
