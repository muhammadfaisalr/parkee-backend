package id.muhammadfaisal.parkee.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.math.BigInteger;

@Entity
@Table(name = "t_parkee")
public class ParkeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "parking_slip")
    private String parkingSlip;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicle_type")
    private Integer vehicleType;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    @Column(name = "check_in_time")
    private String checkInTime;

    @Column(name = "check_out_time")
    private String checkOutTime;

    @Column(name = "discount")
    private  Integer discount;

    @Column(name = "discount_amount")
    private BigInteger discountAmount;

    @Column(name = "base_amount")
    private BigInteger baseAmount;

    @Column(name = "total_amount")
    private BigInteger totalAmount;

    @Column(name = "status")
    private Integer status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getParkingSlip() {
        return parkingSlip;
    }

    public void setParkingSlip(String parkingSlip) {
        this.parkingSlip = parkingSlip;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigInteger getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigInteger discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigInteger getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigInteger baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigInteger getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigInteger totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
