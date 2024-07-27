package com.salaohair.api.services;

import com.salaohair.api.dto.request.FinanceiroRequest;
import com.salaohair.api.dto.response.FinanceiroResponse;

import java.util.List;


public interface FinanceiroService {
    FinanceiroResponse findFinancesById(Long financeiroId);
    List<FinanceiroResponse> findAllFinances();
    FinanceiroResponse createFinances(FinanceiroRequest request);
    FinanceiroResponse updateFinances(Long financeiroId, FinanceiroRequest request);
    void deleteFinances(Long financeiroId);

}
