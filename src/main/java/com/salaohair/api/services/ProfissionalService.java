package com.salaohair.api.services;


import com.salaohair.api.dto.request.ProfissionalRequest;
import com.salaohair.api.dto.response.ProfissionalResponse;

import java.util.List;

public interface ProfissionalService {
    ProfissionalResponse findProfissionalById(Long profissionalId);
    List<ProfissionalResponse> findAllProfisionais();
    ProfissionalResponse createProfissional(ProfissionalRequest request);
    ProfissionalResponse updateProfissional(Long profissionalId, ProfissionalRequest request);
    void deleteProfissinal(Long profissionalId);
}
