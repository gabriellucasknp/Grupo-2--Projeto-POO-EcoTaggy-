package com.ecoTaggy.repository;

import com.ecoTaggy.entity.ImpactoAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ImpactoAmbientalRepository extends JpaRepository<ImpactoAmbiental, Long> {

    Optional<ImpactoAmbiental> findByTransacaoId(Long transacaoId);
}
