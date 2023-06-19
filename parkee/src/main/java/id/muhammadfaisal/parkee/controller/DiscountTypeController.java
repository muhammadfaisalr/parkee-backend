package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.DiscountTypeEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.DiscountTypeRepository;
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
           baseResponse.setData(entities);
       } catch (Exception e) {
           e.printStackTrace();
       }

       return ResponseEntity.ok(baseResponse);
    }

}
