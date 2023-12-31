package id.muhammadfaisal.parkee.controller;

import id.muhammadfaisal.parkee.entity.StatusEntity;
import id.muhammadfaisal.parkee.model.response.BaseResponse;
import id.muhammadfaisal.parkee.repository.StatusRepository;
import id.muhammadfaisal.parkee.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    @Autowired
    public StatusRepository statusRepository;

    @GetMapping
    private ResponseEntity<BaseResponse> getStatuses() {
        BaseResponse baseResponse = new BaseResponse();

        try {
            List<StatusEntity> statusEntities = statusRepository.getStatuses();
            baseResponse.setCode(Constant.RC.SUCCESS);
            baseResponse.setMessage(Constant.RM.SUCCESS);
            baseResponse.setData(statusEntities);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(Constant.RC.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(baseResponse);
    }
}
