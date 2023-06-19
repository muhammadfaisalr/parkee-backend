package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.DiscountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountTypeRepository extends JpaRepository<DiscountTypeEntity, Long> {
    @Query(value = "SELECT * FROM m_discount_type", nativeQuery = true)
    public List<DiscountTypeEntity> getDiscountTypes();
}
