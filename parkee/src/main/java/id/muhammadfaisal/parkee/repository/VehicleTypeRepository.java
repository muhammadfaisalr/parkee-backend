package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.PaymentTypeEntity;
import id.muhammadfaisal.parkee.entity.VehicleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Long> {
    @Query(value = "SELECT * FROM m_vehicle_type", nativeQuery = true)
    public List<VehicleTypeEntity> getVehicleTypes();

    @Query(value = "SELECT price_per_hour FROM m_vehicle_type WHERE id = :id", nativeQuery = true)
    public BigInteger getPricePerHour(int id);

    @Query(value = "SELECT * FROM m_vehicle_type WHERE id = :id", nativeQuery = true)
    public VehicleTypeEntity getById(int id);
}
