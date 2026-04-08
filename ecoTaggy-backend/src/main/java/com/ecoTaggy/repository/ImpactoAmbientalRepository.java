package com.ecoTaggy.repository;

import com.ecoTaggy.entity.ImpactoAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpactoAmbientalRepository extends JpaRepository<ImpactoAmbiental, Long> {
    // Apague qualquer método findByTransacaoId que estiver aqui dentro por enquanto!
}