package az.ingress.mspayment.dao.repository;

import az.ingress.mspayment.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long>{

        }
