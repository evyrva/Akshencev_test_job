package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BootNotificationRequest {

  /**
   * (Required)
   */
  @Valid
  @NotNull
  private ChargingStation chargingStation;
  /**
   * (Required)
   */
  @NotNull
  private BootNotificationRequest.BootReasonEnumType reason;

  /**
   * No args constructor for use in serialization
   */
  public BootNotificationRequest() {
  }

  /**
   * @param reason
   * @param chargingStation
   */
  public BootNotificationRequest(ChargingStation chargingStation, BootReasonEnumType reason) {
    super();
    this.chargingStation = chargingStation;
    this.reason = reason;
  }

  /**
   * (Required)
   */
  public ChargingStation getChargingStation() {
    return chargingStation;
  }

  /**
   * (Required)
   */
  public void setChargingStation(ChargingStation chargingStation) {
    this.chargingStation = chargingStation;
  }

  public BootNotificationRequest withChargingStation(ChargingStation chargingStation) {
    this.chargingStation = chargingStation;
    return this;
  }

  /**
   * (Required)
   */
  public BootReasonEnumType getReason() {
    return reason;
  }

  /**
   * (Required)
   */
  public void setReason(BootReasonEnumType reason) {
    this.reason = reason;
  }

  public BootNotificationRequest withReason(BootReasonEnumType reason) {
    this.reason = reason;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(BootNotificationRequest.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("chargingStation");
    sb.append('=');
    sb.append(((this.chargingStation == null) ? "<null>" : this.chargingStation));
    sb.append(',');
    sb.append("reason");
    sb.append('=');
    sb.append(((this.reason == null) ? "<null>" : this.reason));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.reason == null) ? 0 : this.reason.hashCode()));
    result = ((result * 31) + ((this.chargingStation == null) ? 0
        : this.chargingStation.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof BootNotificationRequest) == false) {
      return false;
    }
    BootNotificationRequest rhs = ((BootNotificationRequest) other);
    return (
        ((this.reason == rhs.reason) || ((this.reason != null) && this.reason.equals(rhs.reason)))
            && ((this.chargingStation == rhs.chargingStation) || ((this.chargingStation != null)
            && this.chargingStation.equals(rhs.chargingStation))));
  }

  public enum BootReasonEnumType {

    APPLICATION_RESET("ApplicationReset"),
    FIRMWARE_UPDATE("FirmwareUpdate"),
    LOCAL_RESET("LocalReset"),
    POWER_UP("PowerUp"),
    REMOTE_RESET("RemoteReset"),
    SCHEDULED_RESET("ScheduledReset"),
    TRIGGERED("Triggered"),
    UNKNOWN("Unknown"),
    WATCHDOG("Watchdog");
    private final String value;
    private final static Map<String, BootReasonEnumType> CONSTANTS = new HashMap<String, BootReasonEnumType>();

    static {
      for (BootReasonEnumType c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    BootReasonEnumType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static BootReasonEnumType fromValue(String value) {
      BootReasonEnumType constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

}
