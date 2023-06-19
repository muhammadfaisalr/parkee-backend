package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.VoucherEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.VoucherRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherController {

    @Autowired
    public VoucherRepository voucherRepository;

    @GetMapping
    private ResponseEntity<BaseResponse> getVouchers() {
        BaseResponse baseResponse = new BaseResponse();

        try {
            List<VoucherEntity> voucherEntities = this.voucherRepository.getVouchers();
            baseResponse.setCode(Constant.RC.SUCCESS);
            baseResponse.setMessage(Constant.RM.SUCCESS);
            baseResponse.setData(voucherEntities);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }
}
