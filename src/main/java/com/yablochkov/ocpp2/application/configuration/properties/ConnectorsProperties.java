package com.yablochkov.ocpp2.application.configuration.properties;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("station")
@Data
public class ConnectorsProperties {

  private Map<Integer, String> connectors;


}
