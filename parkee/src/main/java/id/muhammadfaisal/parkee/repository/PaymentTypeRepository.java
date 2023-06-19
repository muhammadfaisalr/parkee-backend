package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.ParkeeEntity;
import id.muhammadfaisal.parkee.entity.PaymentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, Long> {
    @Query(value = "SELECT * FROM m_payment_type", nativeQuery = true)
    public List<PaymentTypeEntity> getPaymentTypes();

    @Query(value = "SELECT * FROM m_payment_type WHERE id = :id", nativeQuery = true)
    public PaymentTypeEntity getById(int id);
}
