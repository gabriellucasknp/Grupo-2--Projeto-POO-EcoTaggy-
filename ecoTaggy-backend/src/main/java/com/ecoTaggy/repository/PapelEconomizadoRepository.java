package com.ecoTaggy.repository;

import com.ecoTaggy.entity.PapelEconomizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelEconomizadoRepository extends JpaRepository<PapelEconomizado, Long> {
}   //Futuro metodo customizado para buscar por usuário, se necessário. Ex: List<PapelEconomizado> findByUsuarioId(Long usuarioId);S