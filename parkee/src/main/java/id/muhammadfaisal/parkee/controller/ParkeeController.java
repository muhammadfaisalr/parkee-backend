package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.ParkeeEntity;
import id.muhammadfaisal.parkee.entity.PaymentTypeEntity;
import id.muhammadfaisal.parkee.entity.VehicleTypeEntity;
import id.muhammadfaisal.parkee.model.request.ParkeeInqRequest;
import id.muhammadfaisal.parkee.model.request.ParkeePayRequest;
import id.muhammadfaisal.parkee.model.request.ParkeeTrxRequest;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.model.response.transaction.AllTransactionResponse;
import id.muhammadfaisal.parkee.repository.ParkeeRepository;
import id.muhammadfaisal.parkee.repository.PaymentTypeRepository;
import id.muhammadfaisal.parkee.repository.VehicleTypeRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parkee")
public class ParkeeController {

    @Autowired
    public ParkeeRepository parkeeRepository;

    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public PaymentTypeRepository paymentTypeRepository;

    @PostMapping("/new-transaction")
    private ResponseEntity<BaseResponse> postTransaction(@Validated @RequestBody ParkeeTrxRequest parkeeTrxRequest) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            String vehicleNumberTrim = parkeeTrxRequest.getVehicleNumber().trim();
            List<ParkeeEntity> currentParkee = this.parkeeRepository.getParkee(vehicleNumberTrim);

            boolean isCanProcessed = true;

            if (currentParkee.isEmpty()) {
                isCanProcessed = false;
            }

            for (ParkeeEntity parkeeEntity : currentParkee) {
                if (!parkeeEntity.getStatus().equals("2")) {
                    isCanProcessed = false;
                    break;
                }
            }

            if (isCanProcessed) {
                //Process Check In Parking
                ParkeeEntity parkeeEntity = new ParkeeEntity();
                parkeeEntity.setParkingSlip(parkeeTrxRequest.getVehicleNumber());
                parkeeEntity.setVehicleType(parkeeTrxRequest.getVehicleType());
                parkeeEntity.setVehicleNumber(parkeeTrxRequest.getVehicleNumber());
                parkeeEntity.setStatus(Constant.PaymentStatus.NOT_PAID);
                parkeeEntity.setCheckInTime(String.valueOf(LocalDateTime.now()));

                BigInteger price = this.vehicleTypeRepository.getPricePerHour(parkeeTrxRequest.getVehicleType());
                parkeeEntity.setBaseAmount(price);

                this.parkeeRepository.save(parkeeEntity);

                baseResponse.setCode(Constant.RC.SUCCESS);
                baseResponse.setMessage(Constant.RM.SUCCESS_ADD_VEHICLE);
                baseResponse.setData(parkeeEntity);
            } else {
                //Parking Not Allowed. Because Already Check In
                baseResponse.setCode(Constant.RC.NOT_ALLOWED_PARKING);
                baseResponse.setMessage(Constant.RM.NOT_ALLOWED_PARKING);
            }

        } catch (Exception e) {
            baseResponse.setCode(Constant.RC.INTERNAL_SERVER_ERROR);
            baseResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping("/inquiry-transaction")
    public ResponseEntity<BaseResponse> inquiryTransaction(@Validated @RequestBody ParkeeInqRequest parkeeInqRequest) {
        BaseResponse baseResponse = new BaseResponse();

        List<ParkeeEntity> parkeeEntities = this.parkeeRepository.getParkeeNotPaid(parkeeInqRequest.getVehicleNumber());
        try {
            if (parkeeEntities.isEmpty()) {
                // No Vehicle Found
                baseResponse.setCode(Constant.RC.DATA_NOT_F0UND);
                baseResponse.setMessage(Constant.RM.CANNOT_PROCESS_INQUIRY);
            } else {
                ParkeeEntity parkeeEntity = parkeeEntities.get(parkeeEntities.size() - 1);
                BigInteger pricePerHour = this.vehicleTypeRepository.getPricePerHour(parkeeEntity.getVehicleType());
                LocalDateTime now = LocalDateTime.now();
                String checkoutTime = String.valueOf(now);

                parkeeEntity.setCheckOutTime(checkoutTime);
                parkeeEntity.setStatus(Constant.PaymentStatus.PENDING);

                LocalDateTime checkInTime = LocalDateTime.parse(parkeeEntity.getCheckInTime());
                Duration duration = Duration.between(checkInTime, now);
                int totalHour = (int) (duration.toHours() + 1);
                BigInteger priceByHour = pricePerHour.multiply(BigInteger.valueOf(totalHour));
                parkeeEntity.setTotalAmount(priceByHour);

                this.parkeeRepository.updateStatusAndCheckoutTime(Constant.PaymentStatus.PENDING, checkoutTime, parkeeInqRequest.getVehicleNumber());
                baseResponse.setCode(Constant.RC.SUCCESS);
                baseResponse.setMessage(Constant.RM.DATA_FOUND);
                baseResponse.setData(parkeeEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setCode(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }


    @PostMapping("/payment-transaction")
    public ResponseEntity<BaseResponse> paymentTransaction(@Validated @RequestBody ParkeePayRequest parkeePayRequest) {
        BaseResponse baseResponse = new BaseResponse();
        List<ParkeeEntity> parkeeEntities = this.parkeeRepository.getParkeeNotPaid(parkeePayRequest.getVehicleNumber());

        try {

            if (parkeeEntities.isEmpty()) {
                // No Vehicle Found
                baseResponse.setCode(Constant.RC.DATA_NOT_F0UND);
                baseResponse.setMessage(Constant.RM.DATA_NOT_FOUND);
            } else {
                ParkeeEntity parkeeEntity = parkeeEntities.get(parkeeEntities.size() - 1);

                parkeeEntity.setStatus(Constant.PaymentStatus.PAID);
                parkeeEntity.setPaymentMethod(parkeePayRequest.getPaymentMethod());

                this.parkeeRepository.updateStatusToPaid(parkeePayRequest.getVehicleNumber());

                baseResponse.setCode(Constant.RC.SUCCESS);
                baseResponse.setMessage(Constant.RM.SUCCESS);
                baseResponse.setData(parkeeEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setCode(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/all-transaction")
    private ResponseEntity<BaseResponse> getAllTransaction() {
        BaseResponse baseResponse = new BaseResponse();


        try {

            List<ParkeeEntity> parkeeEntities = this.parkeeRepository.getParkees();
            List<AllTransactionResponse> allTransactionResponses = new ArrayList<>();

            for (int i = 0; i < parkeeEntities.size(); i++) {
                ParkeeEntity parkeeEntity = parkeeEntities.get(i);
                AllTransactionResponse allTransactionResponse = new AllTransactionResponse();

                VehicleTypeEntity vehicleTypeEntity = this.vehicleTypeRepository.getById(parkeeEntity.getVehicleType());

                allTransactionResponse.setId(parkeeEntity.getId());
                allTransactionResponse.setParkingSlip(parkeeEntity.getParkingSlip());
                allTransactionResponse.setVehicleNumber(parkeeEntity.getVehicleNumber());
                allTransactionResponse.setVehicleType(vehicleTypeEntity);
                allTransactionResponse.setCheckInTime(parkeeEntity.getCheckInTime());
                allTransactionResponse.setCheckOutTime(parkeeEntity.getCheckOutTime());
                allTransactionResponse.setDiscount(parkeeEntity.getDiscount());
                allTransactionResponse.setTotalAmount(parkeeEntity.getTotalAmount());

                if (parkeeEntity.getPaymentMethod() != null) {
                    PaymentTypeEntity paymentTypeEntity = this.paymentTypeRepository.getById(parkeeEntity.getPaymentMethod());
                    allTransactionResponse.setPaymentMethod(paymentTypeEntity.getName());
                }


                if (parkeeEntity.getStatus() == Constant.PaymentStatus.PENDING) {
                    allTransactionResponse.setStatus(Constant.PaymentStatusText.PENDING);
                } else if (parkeeEntity.getStatus() == Constant.PaymentStatus.PAID) {
                    allTransactionResponse.setStatus(Constant.PaymentStatusText.PAID);
                } else {
                    allTransactionResponse.setStatus(Constant.PaymentStatusText.NOT_PAID);
                }


                allTransactionResponses.add(allTransactionResponse);
            }

            baseResponse.setCode(Constant.RC.SUCCESS);
            baseResponse.setMessage(Constant.RM.SUCCESS );
            baseResponse.setData(allTransactionResponses);
        }catch (Exception e ) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setCode(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }
}
