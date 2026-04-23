package com.ecoTaggy.repository;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface ImpactoAmbientalRepository extends JpaRepository<ImpactoAmbiental, Long> {


    // ESTA É A LINHA QUE ESTÁ FALTANDO:
    // Ela permite que o Spring busque na tabela TB_IMPACTO usando o objeto Usuario como filtro.
    Optional<ImpactoAmbiental> findByUsuario(Usuario usuario);
}


