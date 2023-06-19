package id.muhammadfaisal.parkee.repository;

import id.muhammadfaisal.parkee.entity.PaymentTypeEntity;
import id.muhammadfaisal.parkee.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
    @Query(value = "SELECT * FROM m_status", nativeQuery = true)
    public List<StatusEntity> getStatuses();
}
