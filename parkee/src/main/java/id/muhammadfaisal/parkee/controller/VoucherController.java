package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.VoucherEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.VoucherRepository;
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
            baseResponse.setData(voucherEntities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(baseResponse);
    }
}
