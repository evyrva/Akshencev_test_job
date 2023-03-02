package com.yablochkov.ocpp2.application.configuration;

import com.yablochkov.ocpp2.application.configuration.properties.ConnectorsProperties;
import com.yablochkov.ocpp2.application.configuration.properties.InstanceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ConnectorsProperties.class, InstanceProperties.class})
public class OcppConfig {

}
