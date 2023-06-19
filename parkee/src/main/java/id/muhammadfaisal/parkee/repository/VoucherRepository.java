package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.VehicleTypeEntity;
import id.muhammadfaisal.parkee.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    @Query(value = "SELECT * FROM m_voucher", nativeQuery = true)
    public List<VoucherEntity> getVouchers();
}
