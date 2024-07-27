package com.salaohair.api.repository;

import com.salaohair.api.models.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository  extends JpaRepository<Servicos, Long> {
}
