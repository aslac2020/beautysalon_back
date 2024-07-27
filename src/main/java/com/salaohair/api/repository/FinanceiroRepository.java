package com.salaohair.api.repository;

import com.salaohair.api.models.Financeiro;
import com.salaohair.api.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
    List<Financeiro> findByProfissional(Profissional profissional);
}
