package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.ParkeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParkeeRepository extends JpaRepository<ParkeeEntity, Long>  {
    @Query(value = "SELECT * FROM t_parkee ORDER BY id DESC", nativeQuery = true)
    public List<ParkeeEntity> getParkees();

    @Query(value = "SELECT * FROM t_parkee WHERE vehicle_number = :vehicleNumber AND status IN ('1', '3')", nativeQuery = true)
    public ParkeeEntity getParkeeNotPaid(String vehicleNumber);

    @Query(value = "SELECT * FROM t_parkee WHERE vehicle_number = :vehicleNumber", nativeQuery = true)
    public ParkeeEntity getParkee(String vehicleNumber);

    @Modifying
    @Transactional
    @Query(value = "UPDATE t_parkee SET status = :status, check_out_time = :checkoutTime WHERE vehicle_number = :vehicleNumber", nativeQuery = true)
    public void updateStatusAndCheckoutTime(String status, String checkoutTime,  String vehicleNumber);

    @Modifying
    @Transactional
    @Query(value = "UPDATE t_parkee SET status = '2' WHERE vehicle_number = :vehicleNumber", nativeQuery = true)
    public void updateStatusToPaid(String vehicleNumber);
}
