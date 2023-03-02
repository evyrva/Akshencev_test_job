package com.yablochkov.ocpp2.adapter.csms.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

public class BootNotificationResponse {

  /**
   * (Required)
   */
  @NotNull
  private LocalDateTime currentTime;
  /**
   * (Required)
   */
  @NotNull
  private Integer interval;
  /**
   * (Required)
   */
  @NotNull
  private BootNotificationResponse.Status status;

  /**
   * No args constructor for use in serialization
   */
  public BootNotificationResponse() {
  }

  /**
   * @param currentTime
   * @param interval
   * @param status
   */
  public BootNotificationResponse(LocalDateTime currentTime, Integer interval, Status status) {
    super();
    this.currentTime = currentTime;
    this.interval = interval;
    this.status = status;
  }

  /**
   * (Required)
   */
  public LocalDateTime getCurrentTime() {
    return currentTime;
  }

  /**
   * (Required)
   */
  public void setCurrentTime(LocalDateTime currentTime) {
    this.currentTime = currentTime;
  }

  public BootNotificationResponse withCurrentTime(LocalDateTime currentTime) {
    this.currentTime = currentTime;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getInterval() {
    return interval;
  }

  /**
   * (Required)
   */
  public void setInterval(Integer interval) {
    this.interval = interval;
  }

  public BootNotificationResponse withInterval(Integer interval) {
    this.interval = interval;
    return this;
  }

  /**
   * (Required)
   */
  public Status getStatus() {
    return status;
  }

  /**
   * (Required)
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  public BootNotificationResponse withStatus(Status status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(BootNotificationResponse.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("currentTime");
    sb.append('=');
    sb.append(((this.currentTime == null) ? "<null>" : this.currentTime));
    sb.append(',');
    sb.append("interval");
    sb.append('=');
    sb.append(((this.interval == null) ? "<null>" : this.interval));
    sb.append(',');
    sb.append("status");
    sb.append('=');
    sb.append(((this.status == null) ? "<null>" : this.status));
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
    result = ((result * 31) + ((this.currentTime == null) ? 0 : this.currentTime.hashCode()));
    result = ((result * 31) + ((this.interval == null) ? 0 : this.interval.hashCode()));
    result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof BootNotificationResponse) == false) {
      return false;
    }
    BootNotificationResponse rhs = ((BootNotificationResponse) other);
    return ((((this.currentTime == rhs.currentTime) || ((this.currentTime != null)
        && this.currentTime.equals(rhs.currentTime))) && ((this.interval == rhs.interval) || (
        (this.interval != null) && this.interval.equals(rhs.interval)))) && (
        (this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
  }

  public enum Status {

    ACCEPTED("Accepted"),
    PENDING("Pending"),
    REJECTED("Rejected");
    private final String value;
    private final static Map<String, Status> CONSTANTS = new HashMap<String, Status>();

    static {
      for (Status c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    Status(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static Status fromValue(String value) {
      Status constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

}
