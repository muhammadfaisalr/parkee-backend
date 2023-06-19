package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.VehicleTypeEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.VehicleTypeRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-types")
public class VehicleTypeController {

    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    @GetMapping
    public ResponseEntity<BaseResponse> getVehicleTypes() {
        BaseResponse baseResponse = new BaseResponse();

        try {
            List<VehicleTypeEntity> vehicleTypeEntities = vehicleTypeRepository.getVehicleTypes();
            baseResponse.setCode(Constant.RC.SUCCESS);
            baseResponse.setMessage(Constant.RM.SUCCESS);
            baseResponse.setData(vehicleTypeEntities);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }
}
