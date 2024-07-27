package com.salaohair.api.services.impl;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.request.FinanceiroRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.dto.response.FinanceiroResponse;
import com.salaohair.api.models.Cliente;
import com.salaohair.api.models.Financeiro;
import com.salaohair.api.models.Profissional;
import com.salaohair.api.models.Usuario;
import com.salaohair.api.repository.ClienteRepository;
import com.salaohair.api.repository.FinanceiroRepository;
import com.salaohair.api.repository.ProfissionalRepository;
import com.salaohair.api.repository.UsuarioRepository;
import com.salaohair.api.services.ClienteService;
import com.salaohair.api.services.FinanceiroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroServiceImpl implements FinanceiroService {

   private final FinanceiroRepository repository;
   private final ModelMapper mapper;
   private final ProfissionalRepository profissionalRepository;

   public FinanceiroServiceImpl(FinanceiroRepository repository, ModelMapper mapper, ProfissionalRepository profissionalRepository){
       this.repository = repository;
       this.mapper = mapper;
       this.profissionalRepository = profissionalRepository;
   }


    @Override
    public FinanceiroResponse findFinancesById(Long financeiroId) {
        Financeiro financeiro = repository.findById(financeiroId).orElseThrow(() -> new RuntimeException("Finanças não encontrada"));
        return mapper.map(financeiro, FinanceiroResponse.class);
    }

    @Override
    public List<FinanceiroResponse> findAllFinances() {
        List<Financeiro> financeiros = repository.findAll();
        return financeiros.stream()
                        .map(financeiro ->mapper.map(financeiro, FinanceiroResponse.class)).toList();
    }

    @Override
    public FinanceiroResponse createFinances(FinanceiroRequest request) {
        Financeiro financeiro = mapper.map(request, Financeiro.class);
        Profissional profissional = profissionalRepository.findById(request.getProfissionalId()).orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        financeiro.setProfissional(profissional);
        financeiro = repository.save(financeiro);
        return mapper.map(financeiro, FinanceiroResponse.class);
    }

    @Override
    public FinanceiroResponse updateFinances(Long idFinances, FinanceiroRequest request) {
        Financeiro financeiro = repository.findById(idFinances).orElseThrow(() -> new RuntimeException(String.valueOf(idFinances)));

        financeiro.setDescricao(request.getDescricao());
        financeiro.setValor(request.getValor());
        financeiro.setTipoTransacao(request.getTipoTransacao());
        financeiro.setDataTransacao(request.getDataTransacao());

        if(request.getProfissionalId() != null){
            Profissional profissional = profissionalRepository.findById(request.getProfissionalId()).orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
            financeiro.setProfissional(profissional);
        }

        financeiro = repository.save(financeiro);
        return mapper.map(financeiro, FinanceiroResponse.class);

    }

    @Override
    public void deleteFinances(Long financeiroId) {
        if(!repository.existsById(financeiroId)){
           throw new RuntimeException("Financeiro não encontrado !");
        }

        repository.deleteById(financeiroId);
    }
}
