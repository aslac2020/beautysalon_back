package com.salaohair.api.services.impl;

import com.salaohair.api.dto.request.ServicosRequest;
import com.salaohair.api.dto.response.ServicosResponse;
import com.salaohair.api.models.Servicos;
import com.salaohair.api.repository.ServicosRepository;
import com.salaohair.api.services.ServicosService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosServiceImpl implements ServicosService {

    private final ServicosRepository repository;
    private final ModelMapper mapper;

    public ServicosServiceImpl(ServicosRepository repository, ModelMapper mapper ){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ServicosResponse findServicesById(Long servicesId) {
        Servicos servicos = repository.findById(servicesId).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        return mapper.map(servicos, ServicosResponse.class);
    }

    @Override
    public List<ServicosResponse> findAllServices() {
        List<Servicos> servicos = repository.findAll();
        return servicos.stream()
                .map( servico -> mapper.map(servico, ServicosResponse.class)).toList();
    }

    @Override
    public ServicosResponse createServices(ServicosRequest request) {
       Servicos servicos = mapper.map(request, Servicos.class);
       servicos = repository.save(servicos);
        return mapper.map(servicos, ServicosResponse.class);
    }

    @Override
    public ServicosResponse updateServices(Long servicesId, ServicosRequest request) {
        Servicos servicos = repository.findById(servicesId).orElseThrow(() -> new RuntimeException(String.valueOf(servicesId)));

        servicos.setNome(request.getNome());
        servicos.setDescricao(request.getDescricao());
        servicos.setDuracaoMinutos(request.getDuracaoMinutos());
        servicos.setValor(request.getValor());

        servicos = repository.save(servicos);

        return mapper.map(servicos, ServicosResponse.class);
    }

    @Override
    public void deleteServices(Long servicesId) {
            if(!repository.existsById(servicesId)){
                throw new RuntimeException("Serviço não encontrado");
            }

            repository.deleteById(servicesId);
    }
}
