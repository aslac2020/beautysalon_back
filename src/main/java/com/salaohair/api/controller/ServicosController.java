package com.salaohair.api.controller;

import com.salaohair.api.dto.request.ServicosRequest;
import com.salaohair.api.dto.response.ServicosResponse;
import com.salaohair.api.services.impl.ServicosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicosController {

    @Autowired
    private ServicosServiceImpl servicosService;


    @GetMapping
    public ResponseEntity<List<ServicosResponse>>  findAllServices(){
        return new ResponseEntity<>(servicosService.findAllServices(), HttpStatus.OK);
    }

    @GetMapping("/{servicesId}")
    public ResponseEntity<ServicosResponse>  findServicesById(@PathVariable Long servicesId){
        return new ResponseEntity<>(servicosService.findServicesById(servicesId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServicosResponse> createServices(@RequestBody ServicosRequest request){
        return new ResponseEntity<>(servicosService.createServices(request), HttpStatus.OK);
    }


    @PutMapping("/{servicesId}")
    public ResponseEntity<ServicosResponse> updateServices(@RequestBody ServicosRequest request, @PathVariable Long servicesId ){
        return new ResponseEntity<>(servicosService.updateServices(servicesId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{servicesId}")
    public ResponseEntity<Void> deleteServices(@PathVariable Long servicesId ){
        servicosService.deleteServices(servicesId);
        return ResponseEntity.noContent().build();
    }


}
