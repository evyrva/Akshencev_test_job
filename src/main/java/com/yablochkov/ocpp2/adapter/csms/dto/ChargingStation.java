package com.yablochkov.ocpp2.adapter.csms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChargingStation {

    @Size(max = 20)
    private String serialNumber;
    /**
     * (Required)
     */
    @Size(max = 20)
    @NotNull
    private String model;
    /**
     * (Required)
     */
    @Size(max = 50)
    @NotNull
    private String vendorName;
    @Size(max = 50)
    private String firmwareVersion;

    /**
     * No args constructor for use in serialization
     */
    public ChargingStation() {
    }

    /**
     * @param serialNumber
     * @param model
     * @param vendorName
     * @param firmwareVersion
     */
    public ChargingStation(String serialNumber, String model, String vendorName,
        String firmwareVersion) {
        super();
        this.serialNumber = serialNumber;
        this.model = model;
        this.vendorName = vendorName;
        this.firmwareVersion = firmwareVersion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ChargingStation withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * (Required)
     */
    public String getModel() {
        return model;
    }

    /**
     * (Required)
     */
    public void setModel(String model) {
        this.model = model;
    }

    public ChargingStation withModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * (Required)
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * (Required)
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public ChargingStation withVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public ChargingStation withFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingStation.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("serialNumber");
        sb.append('=');
        sb.append(((this.serialNumber == null) ? "<null>" : this.serialNumber));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null) ? "<null>" : this.model));
        sb.append(',');
        sb.append("vendorName");
        sb.append('=');
        sb.append(((this.vendorName == null) ? "<null>" : this.vendorName));
        sb.append(',');
        sb.append("firmwareVersion");
        sb.append('=');
        sb.append(((this.firmwareVersion == null) ? "<null>" : this.firmwareVersion));
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
        result = ((result * 31) + ((this.model == null) ? 0 : this.model.hashCode()));
        result = ((result * 31) + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode()));
        result = ((result * 31) + ((this.vendorName == null) ? 0 : this.vendorName.hashCode()));
        result = ((result * 31) + ((this.firmwareVersion == null) ? 0
            : this.firmwareVersion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingStation) == false) {
            return false;
        }
        ChargingStation rhs = ((ChargingStation) other);
        return ((((((this.model == rhs.model) || ((this.model != null) && this.model.equals(
            rhs.model)))) && ((this.serialNumber == rhs.serialNumber) || (
            (this.serialNumber != null) && this.serialNumber.equals(rhs.serialNumber)))) && (
            (this.vendorName == rhs.vendorName) || ((this.vendorName != null)
                && this.vendorName.equals(rhs.vendorName)))) && (
            (this.firmwareVersion == rhs.firmwareVersion) || ((this.firmwareVersion != null)
                && this.firmwareVersion.equals(rhs.firmwareVersion))));
    }

}
