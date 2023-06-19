package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.DiscountTypeEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.DiscountTypeRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/discount-types")
public class DiscountTypeController {
    @Autowired
    public DiscountTypeRepository discountTypeRepository;

    @GetMapping()
    public ResponseEntity<BaseResponse> getDiscountTypes() {
       BaseResponse baseResponse = new BaseResponse();

       try {
           List<DiscountTypeEntity> entities = this.discountTypeRepository.getDiscountTypes();
           baseResponse.setCode(Constant.RC.SUCCESS);
           baseResponse.setMessage(Constant.RM.SUCCESS);
           baseResponse.setData(entities);
       } catch (Exception e) {
           e.printStackTrace();
           baseResponse.setMessage(e.getMessage());
           baseResponse.setData(Constant.RC.INTERNAL_SERVER_ERROR);
       }

       return ResponseEntity.ok(baseResponse);
    }

}
