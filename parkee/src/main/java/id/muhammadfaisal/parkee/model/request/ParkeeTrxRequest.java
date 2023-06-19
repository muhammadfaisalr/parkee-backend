package id.muhammadfaisal.parkee.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.checkerframework.common.value.qual.StringVal;

public class ParkeeTrxRequest {
    private String vehicleNumber;
    private int vehicleType;
    private int status;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
