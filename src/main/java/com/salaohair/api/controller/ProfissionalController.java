package com.salaohair.api.controller;

import com.salaohair.api.dto.request.ProfissionalRequest;
import com.salaohair.api.dto.response.ProfissionalResponse;
import com.salaohair.api.services.impl.ProfissionalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalServiceImpl profissionalService;


    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>>  findAllProfissionais(){
        return new ResponseEntity<>(profissionalService.findAllProfisionais(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponse> createProfissional(@RequestBody ProfissionalRequest request){
        return new ResponseEntity<>(profissionalService.createProfissional(request), HttpStatus.OK);
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity<ProfissionalResponse>  findProfissionalById(@PathVariable Long profissionalId){
        return new ResponseEntity<>(profissionalService.findProfissionalById(profissionalId), HttpStatus.OK);
    }

    @PutMapping("/{profissionalId}")
    public ResponseEntity<ProfissionalResponse> updateProfissional(@RequestBody ProfissionalRequest request, @PathVariable Long profissionalId ){
        return new ResponseEntity<>(profissionalService.updateProfissional(profissionalId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{profissionalId}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long profissionalId ){
        profissionalService.deleteProfissinal(profissionalId);
        return ResponseEntity.noContent().build();
    }


}
