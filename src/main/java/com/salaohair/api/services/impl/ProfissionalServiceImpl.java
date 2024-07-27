package com.salaohair.api.services.impl;

import com.salaohair.api.dto.request.ProfissionalRequest;
import com.salaohair.api.dto.response.ProfissionalResponse;
import com.salaohair.api.models.Profissional;
import com.salaohair.api.repository.ProfissionalRepository;
import com.salaohair.api.services.ProfissionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalRepository repository;
    private final ModelMapper modelMapper;


    @Autowired
    public ProfissionalServiceImpl(ProfissionalRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProfissionalResponse findProfissionalById(Long profissionalId) {
        Profissional profissional = repository.findById(profissionalId).orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        return modelMapper.map(profissional, ProfissionalResponse.class);
    }

    @Override
    public List<ProfissionalResponse> findAllProfisionais() {
        List<Profissional> profissionais = repository.findAll();
        return profissionais.stream()
                .map(profissional -> modelMapper.map(profissional, ProfissionalResponse.class)).toList();
    }

    @Override
    public ProfissionalResponse createProfissional(ProfissionalRequest request) {
        Profissional profissional = modelMapper.map(request, Profissional.class);
        profissional = repository.save(profissional);
        return modelMapper.map(profissional, ProfissionalResponse.class);
    }

    @Override
    public ProfissionalResponse updateProfissional(Long profissionalId, ProfissionalRequest request) {
        Profissional profissional = repository.findById(profissionalId).orElseThrow(() -> new RuntimeException(String.valueOf(profissionalId)));

        profissional.setEspecialidades(request.getEspecialidades());
        profissional.setNome(request.getNome());
        profissional.setTelefone(request.getTelefone());

        profissional = repository.save(profissional);
        return modelMapper.map(profissional, ProfissionalResponse.class);

    }

    @Override
    public void deleteProfissinal(Long profissionalId) {
        if(!repository.existsById(profissionalId)){
            throw new RuntimeException("Profissional não encontrado!");
        }

        repository.deleteById(profissionalId);
    }
}
