package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.PaymentTypeEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.PaymentTypeRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment-types")
public class PaymentTypeController {

    @Autowired
    public PaymentTypeRepository paymentTypeRepository;

    @GetMapping
    private ResponseEntity<BaseResponse> getPaymentTypes() {
        BaseResponse baseResponse = new BaseResponse();

        try {
            List<PaymentTypeEntity> paymentTypes = paymentTypeRepository.getPaymentTypes();
            baseResponse.setCode(Constant.RC.SUCCESS);
            baseResponse.setMessage(Constant.RM.SUCCESS);
            baseResponse.setData(paymentTypes);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }
}
