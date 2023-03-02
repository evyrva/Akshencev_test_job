package com.yablochkov.ocpp2.adapter.csms.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public class HeartbeatResponse {

  /**
   * (Required)
   */
  @NotNull
  private LocalDateTime currentTime;

  /**
   * No args constructor for use in serialization
   */
  public HeartbeatResponse() {
  }

  /**
   * @param currentTime
   */
  public HeartbeatResponse(LocalDateTime currentTime) {
    super();
    this.currentTime = currentTime;
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

  public HeartbeatResponse withCurrentTime(LocalDateTime currentTime) {
    this.currentTime = currentTime;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(HeartbeatResponse.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("currentTime");
    sb.append('=');
    sb.append(((this.currentTime == null) ? "<null>" : this.currentTime));
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
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof HeartbeatResponse) == false) {
      return false;
    }
    HeartbeatResponse rhs = ((HeartbeatResponse) other);
    return ((this.currentTime == rhs.currentTime) || ((this.currentTime != null)
        && this.currentTime.equals(rhs.currentTime)));
  }

}
